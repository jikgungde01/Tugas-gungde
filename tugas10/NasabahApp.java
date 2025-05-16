import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class NasabahApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}

// Frame Login
class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Login Pengguna");
        setSize(300, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Username:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        btnLogin = new JButton("Login");
        add(new JLabel()); // Kosong untuk layout
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String user = txtUsername.getText();
            String pass = new String(txtPassword.getPassword());

            if (user.equals("gungde") && pass.equals("bangli25")) {
                JOptionPane.showMessageDialog(this, "Login Berhasil!");
                new DashboardNasabah().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Login Gagal! Username atau Password salah.");
            }
        });
    }
}

// Frame Dashboard Nasabah
class DashboardNasabah extends JFrame {
    private JTextField txtNama, txtAlamat, txtNoRek;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersih;
    private JTable table;
    private DefaultTableModel model;

    public DashboardNasabah() {
        setTitle("Dashboard Pengelolaan Data Nasabah");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(3, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelInput.add(new JLabel("Nama Nasabah:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Alamat:"));
        txtAlamat = new JTextField();
        panelInput.add(txtAlamat);

        panelInput.add(new JLabel("Nomor Rekening:"));
        txtNoRek = new JTextField();
        panelInput.add(txtNoRek);

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

        // Tabel Nasabah
        model = new DefaultTableModel(new String[]{"Nama", "Alamat", "No. Rekening"}, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        // Event Tombol
        btnSimpan.addActionListener(e -> {
            String nama = txtNama.getText();
            String alamat = txtAlamat.getText();
            String norek = txtNoRek.getText();

            if (nama.isEmpty() || alamat.isEmpty() || norek.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua data wajib diisi!");
                return;
            }

            model.addRow(new Object[]{nama, alamat, norek});
            JOptionPane.showMessageDialog(this, "Data nasabah disimpan.");
            clearForm();
        });

        btnUbah.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.setValueAt(txtNama.getText(), selected, 0);
                model.setValueAt(txtAlamat.getText(), selected, 1);
                model.setValueAt(txtNoRek.getText(), selected, 2);
                JOptionPane.showMessageDialog(this, "Data nasabah diubah.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah.");
            }
        });

        btnHapus.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.removeRow(selected);
                JOptionPane.showMessageDialog(this, "Data nasabah dihapus.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus.");
            }
        });

        btnBersih.addActionListener(e -> clearForm());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selected = table.getSelectedRow();
                if (selected >= 0) {
                    txtNama.setText(model.getValueAt(selected, 0).toString());
                    txtAlamat.setText(model.getValueAt(selected, 1).toString());
                    txtNoRek.setText(model.getValueAt(selected, 2).toString());
                }
            }
        });
    }

    private void clearForm() {
        txtNama.setText("");
        txtAlamat.setText("");
        txtNoRek.setText("");
        table.clearSelection();
    }
}
