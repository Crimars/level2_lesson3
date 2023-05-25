package lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

public class Server {
    private static final int PORT = 7858;
    private static ServerSocket server;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            out.println("Server start");
            socket = server.accept();
            out.println("Client connected");

            Scanner sc = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (true){
                String str = sc.nextLine();

                out.println("Client: " + str);

                if (str.equals("end")){
                    out.println("Client disconnected");
                    break;
                }
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
