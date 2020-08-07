package com.company.Lesson_6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private ServerSocket serverSocket;
    private Socket socket;

    public ChatServer() {
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            new Client(socket, "Сервер");

            while(true){
                if(socket.isClosed()){
                    break;
                }
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
