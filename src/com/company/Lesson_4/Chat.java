package com.company.Lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {
    public Chat(String name){
        setTitle(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0, 400,500);

        JPanel chatPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        chatPanel.add(scrollPane);

        add(chatPanel);

        JPanel controlPanel = new JPanel(new BorderLayout());

        JTextField inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            private StringBuilder sb = new StringBuilder(textArea.getText());

            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputField.getText().isBlank()) {
                    return;
                }
                sb.append(textArea.getText())
                        .append("\n").append("Max: ")
                        .append(inputField.getText());
                textArea.setText(sb.toString());
                inputField.setText("");
                sb.setLength(0);
            }
        });

        controlPanel.add(inputField);

        JButton submitBtn = new JButton("Send");
        submitBtn.addActionListener(new SubmitButtonListener(inputField, textArea));
        controlPanel.add(submitBtn, BorderLayout.EAST);

        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
