import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTPServer_2 {

    private static final int PORT = 9999;

    // 获取处理器核数
    private static final int COUNT = Runtime.getRuntime()
            .availableProcessors();
    // 处理的任务量和线程数量、CPU、内存等资源都相关，
    // 一般推荐处理器核数数量的线程
    private static final ExecutorService EXE
            = Executors.newFixedThreadPool(COUNT);



    public static Map<String, Object> SESSION_MAP = new HashMap<>();



    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {      // 这样才能处理多个请求
            // 获取客户端请求socket对象：阻塞方法
            Socket socket = server.accept();
            EXE.submit(new HttpTask(socket));
        }
    }
}

// Http请求任务处理类
class HttpTask implements Runnable{

    private Socket socket;

    public HttpTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 获取客户端请求数据：输入流
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        // 获取客户端输出流，返回响应数据
        OutputStream os = null;
        // 往客户端打印数据
        PrintWriter pw = null;
        try {
            try {
                is = socket.getInputStream();   // 原生字节流，需要包装
                isr = new InputStreamReader(is, "UTF-8");   // 字符、字节流转换
                br = new BufferedReader(isr);   // 在缓冲流里读取，效率更高
                Request_2 request = new Request_2();    // 初始化请求对象
                // 请求数据的解析：http协议报的解包
                    // 1.解析请求行（第一行）：method url version
                String requestLine = br.readLine();     // readLine()：阻塞式方法
                String[] requestLines = requestLine.split(" ");
                request.setMethod(requestLines[0]);
                // url可能格式为：http://localhost:9999/xxx?username=stu&password=123
                    // ?username=stu&password=123 要解析到请求参数中
                String url = requestLines[1];
                if(url.contains("?")){
                    String parameters = url.substring(url.indexOf("?")+1);
                    request.parseParameters(parameters);
                    url = url.substring(0, url.indexOf("?"));
                }
                request.setUrl(url);
                request.setVersion(requestLines[2]);
                    // 2.解析请求头
                    // key:value 每个换行，以空行作为结尾
                String header;
                while ((header = br.readLine()) != null && header.length() != 0){   // 空行：header.length()==0
                    // 解析方法：split 或是 subString获取
                    String key = header.substring(0, header.indexOf(":"));
                    String value = header.substring(header.indexOf(":")+1);
                    request.addHeader(key, value.trim());
                }
                // POST请求，需要根据请求头Content-Length获取请求体的长度
                if("POST".equals(request.getMethod())){
                    String len = request.getHeader("Content-Length");
                    if(len != null){
                        int l = Integer.parseInt(len);
                        char[] chars = new char[l];
                        br.read(chars, 0, l);
                        // 请求参数格式：username=stu&password=123
                        String requestBody = new String(chars);
                        request.parseParameters(requestBody);
                    }
                }
                System.out.println(request);

                os = socket.getOutputStream();
                pw = new PrintWriter(os, true);

                if("/302".equals(request.getUrl())) {
                    pw.println("HTTP/1.1 302 重定向");
                    pw.println("Content-Type: text/html;charset=utf-8");
                    pw.println("Location: https://www.baidu.com");
                }else if("/login".equals(request.getUrl())) {
                    pw.println("HTTP/1.1 200 OK");
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    //判断用户名密码是否满足条件（暂不写，但要有该逻辑）


                    String sessionId = UUID.randomUUID().toString();
                    HTTPServer_2.SESSION_MAP.put(sessionId, username);
                    pw.println("Set-Cookie: SESSIONID="+sessionId);
                    pw.println("Content-Type: text/html; charset=utf-8");
                    String content = "<h2>欢迎用户["
                            + request.getParameter("username")
                            + "]登录</h2>";
                    pw.println("Content-Length: "+content.getBytes().length);
                    pw.println();

                    pw.println(content);
                }else if("/setCookie".equals(request.getUrl())) {
                    pw.println("HTTP/1.1 200 OK");
                    String sessionId = UUID.randomUUID().toString();
//                    HTTPServer_2.SESSION_MAP.put(sessionId);
                    pw.println("Set-Cookie: SESSIONID=" + sessionId);
                    pw.println("Content-Type: text/html; charset=utf-8");
                    String content = "设置Cookie成功";
                    pw.println("Content-Length: "+content.getBytes().length);
                    pw.println();
                    pw.println(content);
                }else if("/getCookie".equals(request.getUrl())){        // 如何没有登录，不允许访问
                    String cookie = request.getHeader("Cookie");
                    String[] cookies = cookie.split(";");
                    for(String s : cookies){
                        String[] s2 = s.split("=");
                        String key = s2[0].trim();
                        String value = s2[1].trim();
                        if(key.equals("SESSIONID")
                                && HTTPServer_2.SESSION_MAP.containsKey(value)){
                            pw.println("HTTP/1.1 200 OK");
                            pw.println("Content-Type: text/html; charset=utf-8");
                            String content = "<h2>用户"
                                    +HTTPServer_2.SESSION_MAP.get(value)+"能够访问</h2>";
                            pw.println("Content-Length: "+content.getBytes().length);
                            pw.println();
                            pw.println(content);
                            return;
                        }
                    }
                    pw.println("HTTP/1.1 403 Forbidden");
                    pw.println("Content-Type: text/html; charset=utf-8");
                    String content = "没有访问权限";
                    pw.println("Content-Length: "+content.getBytes().length);
                    pw.println();
                    pw.println(content);
                }else{
                    // 访问/login.html，转化为访问./login.html
                    InputStream htmlIs = HttpServer.class.getClassLoader()
                            .getResourceAsStream("."+request.getUrl());
                    if(htmlIs != null){
                        pw.println("HTTP/1.1 200 OK");
                        pw.println("Content-Type: text/html; charset=utf-8");
                        pw.println();
                        // 返回webapp下的静态资源文件内容
                        InputStreamReader htmlIsr = new InputStreamReader(htmlIs);
                        BufferedReader htmlBr = new BufferedReader(htmlIsr);
                        String content;
                        while((content=htmlBr.readLine()) != null){
                            pw.println(content);
                        }
                    }else{
                        // 返回404
                        pw.println("HTTP/1.1 404 Not Found");
                        pw.println("Content-Type: text/html; charset=utf-8");
                        pw.println();
                        pw.println("<h2>找不到资源</h2>");
                    }


                }
                
            } finally {
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
                if (is != null)
                    is.close();
                if(pw != null)
                    pw.close();
                if(os != null)
                    os.close();
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

