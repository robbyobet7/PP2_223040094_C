import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormPanel extends JPanel {
    public FormPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Form Inputs
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        inputPanel.add(nameField, gbc);

        // Alamat
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1;
        JTextArea addressArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(addressArea), gbc);

        // Jenis Kelamin
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Jenis Kelamin:"), gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton maleButton = new JRadioButton("Pria");
        JRadioButton femaleButton = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        inputPanel.add(genderPanel, gbc);

        // Hobi
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Hobi:"), gbc);
        gbc.gridx = 1;
        JPanel hobbyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox readingBox = new JCheckBox("Membaca");
        JCheckBox gamingBox = new JCheckBox("Bermain Game");
        JCheckBox travelingBox = new JCheckBox("Traveling");
        JCheckBox watchingBox = new JCheckBox("Menonton Film");
        hobbyPanel.add(readingBox);
        hobbyPanel.add(gamingBox);
        hobbyPanel.add(travelingBox);
        hobbyPanel.add(watchingBox);
        inputPanel.add(hobbyPanel, gbc);

        // Pekerjaan
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Pekerjaan:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> jobComboBox = new JComboBox<>(new String[]{"Programmer", "Desainer", "Manajer", "Lainnya"});
        inputPanel.add(jobComboBox, gbc);

        // Minat
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Minat:"), gbc);
        gbc.gridx = 1;
        JList<String> interestList = new JList<>(new String[]{"Teknologi", "Olahraga", "Musik", "Film"});
        interestList.setVisibleRowCount(1);
        inputPanel.add(new JScrollPane(interestList), gbc);

        // Usia
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Usia:"), gbc);
        gbc.gridx = 1;
        JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(20, 10, 100, 1));
        inputPanel.add(ageSpinner, gbc);

        // Kepuasan
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Tingkat Kepuasan:"), gbc);
        gbc.gridx = 1;
        JSlider satisfactionSlider = new JSlider(0, 100, 50);
        satisfactionSlider.setMajorTickSpacing(25);
        satisfactionSlider.setPaintLabels(true);
        satisfactionSlider.setPaintTicks(true);
        inputPanel.add(satisfactionSlider, gbc);

        // Button dan Tabel
        JButton submitButton = new JButton("Tambah Data");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(submitButton, gbc);

        DefaultTableModel tableModel = new DefaultTableModel(new String[]{
                "Nama", "Alamat", "Gender", "Hobi", "Pekerjaan", "Minat", "Usia", "Kepuasan"
        }, 0);
        JTable table = new JTable(tableModel);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String address = addressArea.getText();
            String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "N/A");
            String hobbies = (readingBox.isSelected() ? "Reading " : "") +
                    (gamingBox.isSelected() ? "Gaming " : "") +
                    (travelingBox.isSelected() ? "Traveling" : "");
            String job = (String) jobComboBox.getSelectedItem();
            String interests = String.join(", ", interestList.getSelectedValuesList());
            int age = (int) ageSpinner.getValue();
            int satisfaction = satisfactionSlider.getValue();

            tableModel.addRow(new Object[]{name, address, gender, hobbies, job, interests, age, satisfaction});

            nameField.setText("");
            addressArea.setText("");
            genderGroup.clearSelection();
            readingBox.setSelected(false);
            gamingBox.setSelected(false);
            travelingBox.setSelected(false);
            jobComboBox.setSelectedIndex(0);
            interestList.clearSelection();
            ageSpinner.setValue(20);
            satisfactionSlider.setValue(50);
        });

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
