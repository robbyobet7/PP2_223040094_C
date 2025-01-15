import javax.swing.*;
import java.awt.*;

public class FormBiodata extends JFrame {

    public FormBiodata() {
        // Menentukan properti jendela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("Form Biodata");

        // Membuat komponen-komponen yang akan digunakan
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);
        JLabel namaLabel = new JLabel("Nama:");
        JLabel nomorhpLabel = new JLabel("Nomor HP:");
        JLabel jeniskelaminLabel = new JLabel("Jenis Kelamin:");

        JTextField namaTextField = new JTextField(15);
        JTextField nomorhpTextField = new JTextField(15);

        JRadioButton lakilakiRadioButton = new JRadioButton("Laki-Laki");
        JRadioButton perempuanRadioButton = new JRadioButton("Perempuan");
        ButtonGroup jeniskelaminGroup = new ButtonGroup();
        jeniskelaminGroup.add(lakilakiRadioButton);
        jeniskelaminGroup.add(perempuanRadioButton);

        JCheckBox foreignCheckBox = new JCheckBox("Warga Negara Asing");

        JButton simpanButton = new JButton("Simpan");

        // Mengatur panel dengan GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Jarak antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Header label (di bagian atas)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(headerLabel, gbc);

        // Label Nama
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(namaLabel, gbc);

        // Label Jenis Kelamin di sebelah Nama
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(jeniskelaminLabel, gbc);

        // Input Nama (di bawah label Nama)
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(namaTextField, gbc);

        // RadioButton Laki-laki (di bawah label Jenis Kelamin)
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lakilakiRadioButton, gbc);

        // Label Nomor HP (di bawah input Nama)
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nomorhpLabel, gbc);

        // RadioButton Perempuan (di bawah Laki-laki)
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(perempuanRadioButton, gbc);

        // Input Nomor HP (di bawah label Nomor HP)
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nomorhpTextField, gbc);

        // Checkbox Warga Negara Asing (di bawah RadioButton Perempuan)
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(foreignCheckBox, gbc);

        // Tombol Simpan (di bawah input Nomor HP dan checkbox, ditempatkan di tengah)
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(simpanButton, gbc);

        // Menambahkan panel ke jendela
        this.add(panel);
    }

    public static void main(String[] args) {
        FormBiodata form = new FormBiodata();
        form.setVisible(true);
    }
}