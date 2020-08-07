package com.company.Lesson_6;

import java.io.IOException;
import java.net.Socket;

public class ChatClient{
    private Socket socket;

    public ChatClient(){
        open();
    }

    private void open() {
        try {
            socket = new Socket("localhost", 8888);
            new Client(socket, "Клиент");
            while(true){
                if(socket.isClosed()){
                    break;
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
