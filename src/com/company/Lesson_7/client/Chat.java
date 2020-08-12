package com.company.Lesson_7.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Chat extends JFrame {
    private JTextArea chatArea;
    private JTextField chatField;
    private MessageListener messageListener;

    public Chat(String title, MessageListener messageListener) {
        prepareGUI(title);
        this.messageListener = messageListener;
    }

    public void prepareGUI(String title) {
        setBounds(600, 300, 500, 500);
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        chatField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(chatField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    public void sendMessage() {
        if (!chatField.getText().isBlank()) {
            messageListener.messagePerformed(chatField.getText());
            chatField.setText("");
            chatField.requestFocus();
        }
    }

    public void push(String message) {
        if (!message.isBlank()) {
            chatArea.append(message);
            chatArea.append("\n");
        }
    }

}
