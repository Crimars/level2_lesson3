package lesson6;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private static final int PORT = 7858;
    private static ServerSocket server;
    private static final String SERVER_ADDRESS = "localhost";
    private static Scanner sc;


    public Client(){
        try {
            Socket socket = new Socket(SERVER_ADDRESS, PORT);

            Thread thread = new Thread(() -> {
                try (Scanner sc = new Scanner(socket.getInputStream());
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    while (true) {
                        String str = sc.nextLine();
                        if (str.equals("end")) {
                            out.println("end");
                            break;
                        }
                        out.println(str);
                                 }
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (true) {
                                    if (sc.hasNext())
                                        sc.nextLine();
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Disconnected");

                            }

                        }
                    }).start();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
