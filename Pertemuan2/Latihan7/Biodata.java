package Latihan7;

import javax.swing.*;
import java.awt.event.*;

public class Biodata extends JFrame {
    private JTextField textFieldNama, textFieldHP;
    private JRadioButton radioLakiLaki, radioPerempuan;
    private JCheckBox checkBoxWNA;
    private JTextArea txtOutput;

    public Biodata() {
        // Set default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout to null
        this.setLayout(null);

        // Label Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(20, 20, 100, 20);
        this.add(labelNama);

        // TextField Nama
        textFieldNama = new JTextField();
        textFieldNama.setBounds(130, 20, 200, 25);
        this.add(textFieldNama);

        // Label Nomor HP
        JLabel labelHP = new JLabel("Nomor HP:");
        labelHP.setBounds(20, 60, 100, 20);
        this.add(labelHP);

        // TextField Nomor HP
        textFieldHP = new JTextField();
        textFieldHP.setBounds(130, 60, 200, 25);
        this.add(textFieldHP);

        // Label Jenis Kelamin
        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        labelJenisKelamin.setBounds(20, 100, 100, 20);
        this.add(labelJenisKelamin);

        // Radio Button Laki-Laki
        radioLakiLaki = new JRadioButton("Laki-Laki");
        radioLakiLaki.setBounds(130, 100, 100, 20);
        this.add(radioLakiLaki);

        // Radio Button Perempuan
        radioPerempuan = new JRadioButton("Perempuan");
        radioPerempuan.setBounds(130, 130, 100, 20);
        this.add(radioPerempuan);

        // Group for radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(radioLakiLaki);
        group.add(radioPerempuan);

        // Checkbox Warga Negara Asing
        checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(130, 160, 200, 20);
        this.add(checkBoxWNA);

        // Button Simpan
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(130, 190, 100, 30);
        this.add(buttonSimpan);

        // TextArea for output
        txtOutput = new JTextArea();
        txtOutput.setBounds(20, 230, 350, 150);
        txtOutput.setEditable(false);
        this.add(txtOutput);

        // ActionListener for button
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simpanBiodata();
            }
        });

        // Set frame size and visibility
        this.setSize(400, 450);
        this.setVisible(true);
    }

    // Method untuk menyimpan dan menampilkan biodata
    private void simpanBiodata() {
        String nama = textFieldNama.getText();
        String nomorHP = textFieldHP.getText();
        String jenisKelamin = radioLakiLaki.isSelected() ? "Laki-Laki" : radioPerempuan.isSelected() ? "Perempuan" : "";
        String wna = checkBoxWNA.isSelected() ? "Ya" : "Bukan";

        // Menampilkan output
        txtOutput.append("Nama       : " + nama + "\n");
        txtOutput.append("Nomor HP   : " + nomorHP + "\n");
        txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
        txtOutput.append("WNA        : " + wna + "\n");
        txtOutput.append("============================================\n");
    }

    public static void main(String[] args) {
        new Biodata();
    }
}