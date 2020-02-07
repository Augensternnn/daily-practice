import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 多线程版本，支持多个客户端请求
public class HttpServer {

    private static final int PORT = 9999;   // 端口号
    //使用处理器核数作为运行的线程数比较合适（线程数太多、太少都不好）
    private static final int COUNT
            = Runtime.getRuntime().availableProcessors();     // availableProcessors()：可用的处理器的数量，返回处理器核数
    private static final ExecutorService EXE
            = Executors.newFixedThreadPool(COUNT);      //  固定线程池
    // 在使用固定线程池的情况下：前提条件：TCP为短连接（每个客户端只可读取一次数据，读取完毕则服务端关闭）

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while(true){
                Socket socket = server.accept();
                EXE.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream is = socket.getInputStream();
                            InputStreamReader isr = new InputStreamReader(is);
                            BufferedReader br = new BufferedReader(isr);
                            // 处理请求行
                            // GET /httpdemo/look HTTP/1.1
                            String requestLine = br.readLine();
                            String[] requestLines = requestLine.split(" ");
                            Request request = new Request();
                            request.setMethod(requestLines[0]);
                            request.setUrl(requestLines[1]);
                            request.setVersion(requestLines[2]);

                            // 处理请求头
                            String requestHeader;
                            while((requestHeader=br.readLine())!=null && requestHeader.length()!=0){
                                String[] header = requestHeader.split(":");
                                request.addHeader(header[0], header[1].trim());     // trim()：字符串去除空格操作
                            }
                            System.out.println(request);
                            String requestParameter;
                            char[] chars = new char[1024];
//                            br.read(chars, 0, )
//                            while((requestParameter=br.read(chars)))
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
