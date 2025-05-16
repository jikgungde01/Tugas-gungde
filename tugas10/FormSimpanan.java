import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class FormSimpanan extends JFrame {
    private JTextField txtNama, txtJumlah;
    private JComboBox<String> cmbJenis;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersih;
    private JTable table;
    private DefaultTableModel model;

    public FormSimpanan() {
        setTitle("Form Pengelolaan Data Simpanan");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel Form
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Nama Nasabah:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("Jenis Simpanan:"));
        cmbJenis = new JComboBox<>(new String[]{"Wajib", "Sukarela", "Pokok"});
        panelForm.add(cmbJenis);

        panelForm.add(new JLabel("Jumlah Simpanan:"));
        txtJumlah = new JTextField();
        panelForm.add(txtJumlah);

        // Panel Tombol
        JPanel panelButton = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        btnBersih = new JButton("Bersihkan");

        panelButton.add(btnSimpan);
        panelButton.add(btnUbah);
        panelButton.add(btnHapus);
        panelButton.add(btnBersih);

        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelButton, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);

        // Tabel
        model = new DefaultTableModel(new String[]{"Nama", "Jenis", "Jumlah"}, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        // Aksi Tombol
        btnSimpan.addActionListener(e -> {
            String nama = txtNama.getText();
            String jenis = cmbJenis.getSelectedItem().toString();
            String jumlah = txtJumlah.getText();

            if (nama.isEmpty() || jumlah.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama dan Jumlah wajib diisi!");
                return;
            }

            model.addRow(new Object[]{nama, jenis, jumlah});
            JOptionPane.showMessageDialog(this, "✅ Data simpanan disimpan.");
            clearForm();
        });

        btnUbah.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.setValueAt(txtNama.getText(), selected, 0);
                model.setValueAt(cmbJenis.getSelectedItem().toString(), selected, 1);
                model.setValueAt(txtJumlah.getText(), selected, 2);
                JOptionPane.showMessageDialog(this, "✏️ Data simpanan diubah.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ Pilih data yang ingin diubah.");
            }
        });

        btnHapus.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.removeRow(selected);
                JOptionPane.showMessageDialog(this, "🗑️ Data simpanan dihapus.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ Pilih data yang ingin dihapus.");
            }
        });

        btnBersih.addActionListener(e -> clearForm());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selected = table.getSelectedRow();
                if (selected >= 0) {
                    txtNama.setText(model.getValueAt(selected, 0).toString());
                    cmbJenis.setSelectedItem(model.getValueAt(selected, 1).toString());
                    txtJumlah.setText(model.getValueAt(selected, 2).toString());
                }
            }
        });
    }

    private void clearForm() {
        txtNama.setText("");
        txtJumlah.setText("");
        cmbJenis.setSelectedIndex(0);
        table.clearSelection();
    }

    // Untuk menjalankan langsung
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormSimpanan().setVisible(true));
    }
}
