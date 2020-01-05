import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// 客户端
// 单客户端、长连接的操作（单线程版本）
public class TcpClient {
    private static final String HOST = "localhost";  // 主机IP：可以写 localhost ，也可以写 主机IP
    private static final int PORT = 9999;   // 端口号（刚才启动的服务器的端口号）
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);
            // 客户端发送数据IO输出流
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);      // autoFlush：代表是否自动刷新; 若不自动刷新，则需要手动调用flush()方法进行刷新
            // 客户端接收数据IO输入流
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            // 接收控制台输入数据
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String line = sc.nextLine();
                pw.println(line);
                String content = br.readLine();
                System.out.println("rev:"+content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}