import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        // Set up JFrame
        setTitle("Aplikasi Java dengan JFC");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menambahkan JMenuBar kustom
        setJMenuBar(new AppMenuBar(this));

        // Panel Utama untuk Navigasi
        JPanel mainPanel = new JPanel(new CardLayout());
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Selamat Datang di Aplikasi Java"));
        mainPanel.add(homePanel, "Home");

        // Form Panel
        JPanel formPanel = new FormPanel();
        mainPanel.add(formPanel, "Form");

        // Menambahkan mainPanel ke JFrame
        add(mainPanel);

        // Event Handling untuk Navigasi
        AppMenuBar.addFormMenuListener(() -> {
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, "Form");
        });
    }
}
