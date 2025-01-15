package Tugas;

import javax.swing.*;
import java.awt.event.*;

public class ResetExit extends JFrame {
    private JTextField textFieldNama, textFieldHP;
    private JRadioButton radioLakiLaki, radioPerempuan;
    private JCheckBox checkBoxWNA;
    private JTextArea txtOutput;
    private JList<String> listTabungan;
    private ButtonGroup group;

    public ResetExit() {
        // Set default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout to null
        this.setLayout(null);

        // Membuat menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetItem = new JMenuItem("Reset");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        // Menambahkan menu item ke menu
        menu.add(resetItem);
        menu.add(exitItem);
        
        // Menambahkan menu ke menu bar
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        // ActionListener untuk Reset
        resetItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetForm(); // Panggil method resetForm untuk membersihkan inputan dan output
            }
        });

        // ActionListener untuk Exit
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Keluar dari aplikasi
            }
        });

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
        group = new ButtonGroup();
        group.add(radioLakiLaki);
        group.add(radioPerempuan);

        // Checkbox Warga Negara Asing
        checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(130, 160, 200, 20);
        this.add(checkBoxWNA);

        // Label untuk jenis tabungan
        JLabel labelTabungan = new JLabel("Jenis Tabungan:");
        labelTabungan.setBounds(20, 190, 100, 20);
        this.add(labelTabungan);

        // List pilihan jenis tabungan
        String[] tabunganOptions = { "Tabungan Pendidikan", "Tabungan Haji", "Tabungan Investasi", "Tabungan Umum" };
        listTabungan = new JList<>(tabunganOptions);
        listTabungan.setBounds(130, 190, 200, 80);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // hanya bisa memilih satu
        this.add(listTabungan);

        // Button Simpan
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(130, 280, 100, 30);
        this.add(buttonSimpan);

        // TextArea for output
        txtOutput = new JTextArea();
        txtOutput.setEditable(false); // Tidak dapat di-edit oleh user

        // JScrollPane untuk JTextArea
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(20, 320, 350, 150); // Set ukuran area scroll
        this.add(scrollPane);

        // ActionListener for button
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simpanBiodata();
            }
        });

        // Set frame size and visibility
        this.setSize(400, 550);
        this.setVisible(true);
    }

    // Method untuk menyimpan dan menampilkan biodata
    private void simpanBiodata() {
        String nama = textFieldNama.getText();
        String nomorHP = textFieldHP.getText();
        String jenisKelamin = radioLakiLaki.isSelected() ? "Laki-Laki" : radioPerempuan.isSelected() ? "Perempuan" : "";
        String wna = checkBoxWNA.isSelected() ? "Ya" : "Tidak";
        String jenisTabungan = listTabungan.getSelectedValue();

        // Validasi apakah tabungan dipilih
        if (jenisTabungan == null) {
            jenisTabungan = "Belum Dipilih";
        }

        // Menampilkan output
        txtOutput.append("Nama       : " + nama + "\n");
        txtOutput.append("Nomor HP   : " + nomorHP + "\n");
        txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
        txtOutput.append("WNA        : " + wna + "\n");
        txtOutput.append("Jenis Tabungan : " + jenisTabungan + "\n");
        txtOutput.append("============================================\n");
    }

    // Method untuk reset form
    private void resetForm() {
        textFieldNama.setText("");
        textFieldHP.setText("");
        group.clearSelection();
        checkBoxWNA.setSelected(false);
        listTabungan.clearSelection();
        txtOutput.setText("");
    }

    public static void main(String[] args) {
        new ResetExit();
    }
}