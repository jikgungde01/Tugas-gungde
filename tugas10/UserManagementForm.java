import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class UserManagementForm extends JFrame {
    private JTextField txtUsername, txtNamaLengkap, txtRole;
    private JPasswordField txtPassword;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersih;
    private JTable table;
    private DefaultTableModel model;

    public UserManagementForm() {
        setTitle("Pengelolaan Data User");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(4, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        panelInput.add(txtUsername);

        panelInput.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        panelInput.add(txtPassword);

        panelInput.add(new JLabel("Nama Lengkap:"));
        txtNamaLengkap = new JTextField();
        panelInput.add(txtNamaLengkap);

        panelInput.add(new JLabel("Role:"));
        txtRole = new JTextField();
        panelInput.add(txtRole);

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

        // Tabel User
        model = new DefaultTableModel(new String[]{"Username", "Password", "Nama Lengkap", "Role"}, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        // Event Tombol
        btnSimpan.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            String namaLengkap = txtNamaLengkap.getText();
            String role = txtRole.getText();

            if (username.isEmpty() || password.isEmpty() || namaLengkap.isEmpty() || role.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua data wajib diisi!");
                return;
            }

            model.addRow(new Object[]{username, password, namaLengkap, role});
            JOptionPane.showMessageDialog(this, "Data user berhasil disimpan.");
            clearForm();
        });

        btnUbah.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.setValueAt(txtUsername.getText(), selected, 0);
                model.setValueAt(new String(txtPassword.getPassword()), selected, 1);
                model.setValueAt(txtNamaLengkap.getText(), selected, 2);
                model.setValueAt(txtRole.getText(), selected, 3);
                JOptionPane.showMessageDialog(this, "Data user berhasil diubah.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah.");
            }
        });

        btnHapus.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected >= 0) {
                model.removeRow(selected);
                JOptionPane.showMessageDialog(this, "Data user berhasil dihapus.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus.");
            }
        });

        btnBersih.addActionListener(e -> clearForm());

        // Klik tabel isi form
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selected = table.getSelectedRow();
                if (selected >= 0) {
                    txtUsername.setText(model.getValueAt(selected, 0).toString());
                    txtPassword.setText(model.getValueAt(selected, 1).toString());
                    txtNamaLengkap.setText(model.getValueAt(selected, 2).toString());
                    txtRole.setText(model.getValueAt(selected, 3).toString());
                }
            }
        });
    }

    private void clearForm() {
        txtUsername.setText("");
        txtPassword.setText("");
        txtNamaLengkap.setText("");
        txtRole.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserManagementForm().setVisible(true));
    }
}
