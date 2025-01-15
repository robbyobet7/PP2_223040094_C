import javax.swing.*;
import java.awt.event.*;
public class ComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Example");
        String[] options = { "Jungler", "Goldlane", "Midlane", "Roamer", "Explane" };

        // Membuat JComboBox dengan opsi
        JComboBox<String> comboBox = new JComboBox<>(options);

        // Tambahkan pendengar aksi
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengambil item yang dipilih
                String selected = (String) comboBox.getSelectedItem();
                System.out.println("Selec ted: " + selected);
            }
        });

        // Atur layout dan tambahkan ke frame
        frame.setLayout(null);
        comboBox.setBounds(50, 50, 150, 20);
        frame.add(comboBox);

        // Konfigurasi frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}