import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class HistoryTransaksiPinjaman extends JFrame {
    private JTextField txtID, txtNama, txtTanggal, txtJumlah;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersih;
    private JTable table;
    private DefaultTableModel model;

    public HistoryTransaksiPinjaman() {
        setTitle("History Transaksi Pinjaman");
        setSize(750, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(4, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("ID Transaksi:"));
        txtID = new JTextField();
        panelInput.add(txtID);

        panelInput.add(new JLabel("Nama Peminjam:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Tanggal (YYYY-MM-DD):"));
        txtTanggal = new JTextField();
        panelInput.add(txtTanggal);

        panelInput.add(new JLabel("Jumlah Pembayaran:"));
        txtJumlah = new JTextField();
        panelInput.add(txtJumlah);

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
                "ID Transaksi", "Nama Peminjam", "Tanggal", "Jumlah"
        }, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        // Event Tombol
        btnSimpan.addActionListener(e -> {
            String id = txtID.getText();
            String nama = txtNama.getText();
            String tanggal = txtTanggal.getText();
            String jumlah = txtJumlah.getText();

            if (id.isEmpty() || nama.isEmpty() || tanggal.isEmpty() || jumlah.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua data wajib diisi!");
                return;
            }

            model.addRow(new Object[]{id, nama, tanggal, jumlah});
            JOptionPane.showMessageDialog(this, "✅ Transaksi disimpan.");
            clearForm();
        });

        btnUbah.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.setValueAt(txtID.getText(), selected, 0);
                model.setValueAt(txtNama.getText(), selected, 1);
                model.setValueAt(txtTanggal.getText(), selected, 2);
                model.setValueAt(txtJumlah.getText(), selected, 3);
                JOptionPane.showMessageDialog(this, "✏️ Transaksi diubah.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ Pilih data yang ingin diubah.");
            }
        });

        btnHapus.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.removeRow(selected);
                JOptionPane.showMessageDialog(this, "🗑️ Transaksi dihapus.");
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
                    txtID.setText(model.getValueAt(selected, 0).toString());
                    txtNama.setText(model.getValueAt(selected, 1).toString());
                    txtTanggal.setText(model.getValueAt(selected, 2).toString());
                    txtJumlah.setText(model.getValueAt(selected, 3).toString());
                }
            }
        });
    }

    private void clearForm() {
        txtID.setText("");
        txtNama.setText("");
        txtTanggal.setText("");
        txtJumlah.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HistoryTransaksiPinjaman().setVisible(true));
    }
}
