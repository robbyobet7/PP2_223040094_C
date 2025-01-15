

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JButton processButton;
    private JProgressBar progressBar;
    private JLabel statusLabel;
    private JTextArea outputArea;
    private JScrollPane scrollPane;

    public View() {
        setTitle("Konkurensi dengan MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        statusLabel = new JLabel("Siap");
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        processButton = new JButton("Mulai Proses");

        outputArea = new JTextArea();
        outputArea.setEditable(false);

       // Set preferred size for JTextArea to enable scrolling.
        outputArea.setPreferredSize(new Dimension(500, 1000)); // Set ukuran agar scroll bisa muncul

        scrollPane = new JScrollPane(outputArea);
         // Set preferred size for JScrollPane to enable scrolling
        scrollPane.setPreferredSize(new Dimension(500, 200)); // set ukuran agar scroll bisa muncul
        // Set scrollbar policy
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(processButton);
        controlPanel.add(progressBar);

        mainPanel.add(statusLabel, BorderLayout.NORTH);
        mainPanel.add(controlPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);


        add(mainPanel);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public JButton getProcessButton() {
        return processButton;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public JTextArea getOutputArea() {
        return outputArea;
    }

    public void updateOutputArea(String text) {
        outputArea.append(text + "\n");
    }
}