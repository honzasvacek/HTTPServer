import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, IOException {

        System.out.println("krok 1");
        ServerSocket server = new ServerSocket(9999);

        //čekám až se na server neěkdo připojí
        try (Socket socket = server.accept()) {

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("HTTP/1.1 200 OK");
            out.println("Connection: close");
            out.println("Connect-Type: text/html; charset=UTF-8");
            out.println();
            out.println("<html><head></head><body></body></html>");
            out.close();

        }
    }
}
