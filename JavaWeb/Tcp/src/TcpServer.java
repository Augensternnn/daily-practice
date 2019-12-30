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

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }



}

