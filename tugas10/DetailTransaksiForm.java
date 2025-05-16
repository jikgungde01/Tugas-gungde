import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class DetailTransaksiForm extends JFrame {
    private JTextField txtID, txtNamaBarang, txtJumlah, txtHargaSatuan, txtTotalHarga;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersih;
    private JTable table;
    private DefaultTableModel model;

    public DetailTransaksiForm() {
        setTitle("Form Detail Transaksi");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(5, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("ID Transaksi:"));
        txtID = new JTextField();
        panelInput.add(txtID);

        panelInput.add(new JLabel("Nama Barang/Jasa:"));
        txtNamaBarang = new JTextField();
        panelInput.add(txtNamaBarang);

        panelInput.add(new JLabel("Jumlah:"));
        txtJumlah = new JTextField();
        panelInput.add(txtJumlah);

        panelInput.add(new JLabel("Harga Satuan:"));
        txtHargaSatuan = new JTextField();
        panelInput.add(txtHargaSatuan);

        panelInput.add(new JLabel("Total Harga:"));
        txtTotalHarga = new JTextField();
        txtTotalHarga.setEditable(false);
        panelInput.add(txtTotalHarga);

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
                "ID Transaksi", "Nama Barang/Jasa", "Jumlah", "Harga Satuan", "Total Harga"
        }, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        // Hitung total harga saat jumlah atau harga satuan diubah
        KeyAdapter calculateTotal = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                calculateTotalHarga();
            }
        };
        txtJumlah.addKeyListener(calculateTotal);
        txtHargaSatuan.addKeyListener(calculateTotal);

        // Event Tombol
        btnSimpan.addActionListener(e -> {
            String id = txtID.getText();
            String nama = txtNamaBarang.getText();
            String jumlahStr = txtJumlah.getText();
            String hargaStr = txtHargaSatuan.getText();
            String totalStr = txtTotalHarga.getText();

            if (id.isEmpty() || nama.isEmpty() || jumlahStr.isEmpty() || hargaStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua data wajib diisi!");
                return;
            }

            model.addRow(new Object[]{id, nama, jumlahStr, hargaStr, totalStr});
            JOptionPane.showMessageDialog(this, "✅ Data transaksi disimpan.");
            clearForm();
        });

        btnUbah.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.setValueAt(txtID.getText(), selected, 0);
                model.setValueAt(txtNamaBarang.getText(), selected, 1);
                model.setValueAt(txtJumlah.getText(), selected, 2);
                model.setValueAt(txtHargaSatuan.getText(), selected, 3);
                model.setValueAt(txtTotalHarga.getText(), selected, 4);
                JOptionPane.showMessageDialog(this, "✏️ Data transaksi diubah.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ Pilih data yang ingin diubah.");
            }
        });

        btnHapus.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.removeRow(selected);
                JOptionPane.showMessageDialog(this, "🗑️ Data transaksi dihapus.");
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
                    txtNamaBarang.setText(model.getValueAt(selected, 1).toString());
                    txtJumlah.setText(model.getValueAt(selected, 2).toString());
                    txtHargaSatuan.setText(model.getValueAt(selected, 3).toString());
                    txtTotalHarga.setText(model.getValueAt(selected, 4).toString());
                }
            }
        });
    }

    private void calculateTotalHarga() {
        try {
            int jumlah = Integer.parseInt(txtJumlah.getText());
            double harga = Double.parseDouble(txtHargaSatuan.getText());
            double total = jumlah * harga;
            txtTotalHarga.setText(String.format("%.2f", total));
        } catch (NumberFormatException e) {
            txtTotalHarga.setText("");
        }
    }

    private void clearForm() {
        txtID.setText("");
        txtNamaBarang.setText("");
        txtJumlah.setText("");
        txtHargaSatuan.setText("");
        txtTotalHarga.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DetailTransaksiForm().setVisible(true));
    }
}
