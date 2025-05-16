import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class FormPinjaman extends JFrame {
    private JTextField txtNama, txtJumlah, txtLama, txtBunga;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersih;
    private JTable table;
    private DefaultTableModel model;

    public FormPinjaman() {
        setTitle("Form Pengelolaan Data Pinjaman");
        setSize(750, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(4, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("Nama Peminjam:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Jumlah Pinjaman:"));
        txtJumlah = new JTextField();
        panelInput.add(txtJumlah);

        panelInput.add(new JLabel("Lama Pinjaman (bulan):"));
        txtLama = new JTextField();
        panelInput.add(txtLama);

        panelInput.add(new JLabel("Bunga (%):"));
        txtBunga = new JTextField();
        panelInput.add(txtBunga);

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
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelButton, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);

        // Tabel
        model = new DefaultTableModel(new String[]{
                "Nama", "Jumlah", "Lama (bulan)", "Bunga (%)"
        }, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        // Event Tombol
        btnSimpan.addActionListener(e -> {
            String nama = txtNama.getText();
            String jumlah = txtJumlah.getText();
            String lama = txtLama.getText();
            String bunga = txtBunga.getText();

            if (nama.isEmpty() || jumlah.isEmpty() || lama.isEmpty() || bunga.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua data wajib diisi!");
                return;
            }

            model.addRow(new Object[]{nama, jumlah, lama, bunga});
            JOptionPane.showMessageDialog(this, "✅ Data pinjaman disimpan.");
            clearForm();
        });

        btnUbah.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.setValueAt(txtNama.getText(), selected, 0);
                model.setValueAt(txtJumlah.getText(), selected, 1);
                model.setValueAt(txtLama.getText(), selected, 2);
                model.setValueAt(txtBunga.getText(), selected, 3);
                JOptionPane.showMessageDialog(this, "✏️ Data pinjaman diubah.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ Pilih data yang ingin diubah.");
            }
        });

        btnHapus.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.removeRow(selected);
                JOptionPane.showMessageDialog(this, "🗑️ Data pinjaman dihapus.");
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
                    txtJumlah.setText(model.getValueAt(selected, 1).toString());
                    txtLama.setText(model.getValueAt(selected, 2).toString());
                    txtBunga.setText(model.getValueAt(selected, 3).toString());
                }
            }
        });
    }

    private void clearForm() {
        txtNama.setText("");
        txtJumlah.setText("");
        txtLama.setText("");
        txtBunga.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPinjaman().setVisible(true));
    }
}
