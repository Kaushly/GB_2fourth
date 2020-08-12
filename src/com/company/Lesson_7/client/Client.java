package com.company.Lesson_7.client;

import com.company.Lesson_7.server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String login;
    private String password;

    private Chat chat;

    public Client(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void open() throws IOException {
        init();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doAuthorization();
                    while (true) {
                        try {
                            String message = in.readUTF();
                            if (message.equalsIgnoreCase("/end")) {
                                break;
                            }
                            chat.push(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        })
                .start();
    }

    public void init() throws IOException {
        socket = new Socket("localhost", Server.PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        chat = new Chat("Chat: " + login, new MessageListener() {
            @Override
            public void messagePerformed(String message) {
                try {
                    out.writeUTF(message);
                } catch (IOException ioException) {
                    throw new RuntimeException("Sending message error", ioException);
                }
            }
        });
    }

    private void doAuthorization() throws IOException {
        out.writeUTF("/auth " + login + " " + password);
        while (true) {
            String message = in.readUTF();
            if (message.startsWith("/authok")) {
                System.out.println("Authorized");
                break;
            }
        }
    }
}
