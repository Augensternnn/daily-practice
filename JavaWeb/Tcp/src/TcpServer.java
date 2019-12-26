import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    private static final int PORT = 9999;
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            Socket socket = server.accept();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            String data = null;
            while ((data = reader.readLine()) != null) {
                System.out.println(data);
                pw.println("已经收到数据【"+data+"】");



            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }



}

