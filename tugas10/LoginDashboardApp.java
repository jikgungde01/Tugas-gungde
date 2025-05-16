import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LoginDashboardApp {

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
        setTitle("Login");
        setSize(350, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));
        setResizable(false);

        add(new JLabel("Username:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        btnLogin = new JButton("Login");
        add(new JLabel()); // kosong untuk grid
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String user = txtUsername.getText();
            String pass = new String(txtPassword.getPassword());

            if(user.equals("gungde") && pass.equals("bangli25")){
                JOptionPane.showMessageDialog(this, "Login Berhasil!");
                new DashboardFrame().setVisible(true);
                this.dispose(); // tutup frame login
            } else {
                JOptionPane.showMessageDialog(this, "Login Gagal! Username atau Password salah.");
                txtPassword.setText("");
            }
        });
    }
}

// Frame Dashboard setelah login sukses
class DashboardFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersihkan;
    private JTable table;
    private DefaultTableModel model;

    public DashboardFrame() {
        setTitle("Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        // Panel input
        JPanel panelInput = new JPanel(new GridLayout(3, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        panelInput.add(txtUsername);

        panelInput.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        panelInput.add(txtPassword);

        // Panel tombol aksi
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        btnBersihkan = new JButton("Bersihkan");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnUbah);
        panelTombol.add(btnHapus);
        panelTombol.add(btnBersihkan);

        // Panel atas (input + tombol)
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        add(panelAtas, BorderLayout.NORTH);

        // Tabel
        model = new DefaultTableModel(new String[]{"Username", "Password"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // Event tombol Simpan
        btnSimpan.addActionListener(e -> {
            String user = txtUsername.getText().trim();
            String pass = new String(txtPassword.getPassword()).trim();

            if(user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username dan Password harus diisi.");
                return;
            }

            model.addRow(new Object[]{user, pass});
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
            clearForm();
        });

        // Event tombol Ubah
        btnUbah.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if(selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah dari tabel.");
                return;
            }
            String user = txtUsername.getText().trim();
            String pass = new String(txtPassword.getPassword()).trim();

            if(user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username dan Password harus diisi.");
                return;
            }

            model.setValueAt(user, selectedRow, 0);
            model.setValueAt(pass, selectedRow, 1);
            JOptionPane.showMessageDialog(this, "Data berhasil diubah.");
            clearForm();
        });

        // Event tombol Hapus
        btnHapus.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if(selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus dari tabel.");
                return;
            }
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
            clearForm();
        });

        // Event tombol Bersihkan
        btnBersihkan.addActionListener(e -> clearForm());

        // Event klik baris tabel untuk mengisi form
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if(selectedRow >= 0) {
                    txtUsername.setText(model.getValueAt(selectedRow, 0).toString());
                    txtPassword.setText(model.getValueAt(selectedRow, 1).toString());
                }
            }
        });
    }

    private void clearForm() {
        txtUsername.setText("");
        txtPassword.setText("");
        table.clearSelection();
    }
}
