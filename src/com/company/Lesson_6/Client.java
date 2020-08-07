package com.company.Lesson_6;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Scanner in;
    private Scanner input;
    private PrintStream out;
    private Thread inThread;
    private Thread outThread;

    public Client(Socket socket, String name) {
        try {
            in = new Scanner(socket.getInputStream());
            input = new Scanner(System.in);
            out = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        outThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (input.hasNext()) {
                        String massage = input.nextLine();
                        out.println(name + ": " + massage);
                        if (massage.equalsIgnoreCase("/end")) break;
                    }
                }
                close(socket);
            }
        });
        outThread.start();

        inThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (in.hasNext()) {
                        String massage = in.nextLine();
                        System.out.println(massage);
                        if (massage.equalsIgnoreCase("/end")) break;
                    }
                }
                close(socket);
            }
        });
        inThread.start();

    }

    private void close(Socket socket) {
        inThread.interrupt();
        outThread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
