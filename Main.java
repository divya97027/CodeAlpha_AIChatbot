import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    public Main() {

        setTitle("AI Chatbot");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        sendButton.addActionListener(this);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        chatArea.append("Chatbot: Hello! I am your AI Chatbot.\n");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String userText = inputField.getText().toLowerCase();
        chatArea.append("You: " + userText + "\n");

        // NLP + Rule-based logic
        if (userText.contains("hi") || userText.contains("hello")) {
            chatArea.append("Chatbot: Hello! How can I help you?\n");
        }
        else if (userText.contains("how are you")) {
            chatArea.append("Chatbot: I am fine, thank you!\n");
        }
        else if (userText.contains("java")) {
            chatArea.append("Chatbot: Java is a popular programming language.\n");
        }
        else if (userText.contains("bye")) {
            chatArea.append("Chatbot: Goodbye! Have a nice day.\n");
        }
        else {
            chatArea.append("Chatbot: Sorry, I don't understand that.\n");
        }

        inputField.setText("");
    }

    public static void main(String[] args) {
        new Main();
    }
}
