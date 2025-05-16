import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class HalamanSimpanan extends JFrame {
    private JTextField txtNama, txtTanggal, txtJumlah;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersih;
    private JTable table;
    private DefaultTableModel model;

    public HalamanSimpanan() {
        setTitle("Halaman Data Simpanan");
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

        panelForm.add(new JLabel("Tanggal Simpan (YYYY-MM-DD):"));
        txtTanggal = new JTextField();
        panelForm.add(txtTanggal);

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

        // Tabel Simpanan
        model = new DefaultTableModel(new String[]{"Nama", "Tanggal", "Jumlah"}, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        // Aksi tombol Simpan
        btnSimpan.addActionListener(e -> {
            String nama = txtNama.getText();
            String tanggal = txtTanggal.getText();
            String jumlah = txtJumlah.getText();

            if (nama.isEmpty() || tanggal.isEmpty() || jumlah.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua data wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            model.addRow(new Object[]{nama, tanggal, jumlah});
            JOptionPane.showMessageDialog(this, "✅ Data simpanan disimpan.");
            clearForm();
        });

        // Aksi tombol Ubah
        btnUbah.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.setValueAt(txtNama.getText(), selected, 0);
                model.setValueAt(txtTanggal.getText(), selected, 1);
                model.setValueAt(txtJumlah.getText(), selected, 2);
                JOptionPane.showMessageDialog(this, "✏️ Data simpanan diubah.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ Pilih data yang ingin diubah.");
            }
        });

        // Aksi tombol Hapus
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

        // Aksi tombol Bersih
        btnBersih.addActionListener(e -> clearForm());

        // Isi form saat klik tabel
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selected = table.getSelectedRow();
                if (selected >= 0) {
                    txtNama.setText(model.getValueAt(selected, 0).toString());
                    txtTanggal.setText(model.getValueAt(selected, 1).toString());
                    txtJumlah.setText(model.getValueAt(selected, 2).toString());
                }
            }
        });
    }

    private void clearForm() {
        txtNama.setText("");
        txtTanggal.setText("");
        txtJumlah.setText("");
        table.clearSelection();
    }

    // Untuk menjalankan langsung halaman simpanan
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HalamanSimpanan().setVisible(true));
    }
}
