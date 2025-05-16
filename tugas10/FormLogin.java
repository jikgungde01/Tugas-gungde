import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class FormLogin extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersihkan, btnLogin;
    private JTable table;
    private DefaultTableModel model;

    public FormLogin() {
        setTitle("Form Login");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel input
        JPanel panelInput = new JPanel(new GridLayout(3, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        panelInput.add(txtUsername);

        panelInput.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        panelInput.add(txtPassword);

        btnLogin = new JButton("Login");
        panelInput.add(btnLogin);

        btnBersihkan = new JButton("Bersihkan");
        panelInput.add(btnBersihkan);

        add(panelInput, BorderLayout.NORTH);

        // Panel tombol aksi selain login
        JPanel panelAksi = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnSimpan = new JButton("Simpan");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");

        panelAksi.add(btnSimpan);
        panelAksi.add(btnUbah);
        panelAksi.add(btnHapus);

        add(panelAksi, BorderLayout.CENTER);

        // Tabel user
        model = new DefaultTableModel(new String[]{"Username", "Password"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.SOUTH);

        // Event tombol login
        btnLogin.addActionListener(e -> {
            String user = txtUsername.getText();
            String pass = new String(txtPassword.getPassword());

            if(user.equals("gungde") && pass.equals("bangli25")){
                JOptionPane.showMessageDialog(this, "Login Berhasil!");
            } else {
                JOptionPane.showMessageDialog(this, "Login Gagal! Username atau Password salah.");
            }
        });

        // Event tombol bersihkan
        btnBersihkan.addActionListener(e -> {
            txtUsername.setText("");
            txtPassword.setText("");
            table.clearSelection();
        });

        // Tombol Simpan (menambah baris baru ke tabel)
        btnSimpan.addActionListener(e -> {
            String user = txtUsername.getText();
            String pass = new String(txtPassword.getPassword());
            if(user.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(this, "Username dan Password harus diisi!");
                return;
            }
            model.addRow(new Object[]{user, pass});
            JOptionPane.showMessageDialog(this, "Data disimpan.");
        });

        // Tombol Ubah (mengubah data baris yang dipilih)
        btnUbah.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if(selected >= 0){
                String user = txtUsername.getText();
                String pass = new String(txtPassword.getPassword());
                if(user.isEmpty() || pass.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Username dan Password harus diisi!");
                    return;
                }
                model.setValueAt(user, selected, 0);
                model.setValueAt(pass, selected, 1);
                JOptionPane.showMessageDialog(this, "Data diubah.");
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah.");
            }
        });

        // Tombol Hapus (menghapus baris yang dipilih)
        btnHapus.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if(selected >= 0){
                model.removeRow(selected);
                JOptionPane.showMessageDialog(this, "Data dihapus.");
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus.");
            }
        });

        // Saat klik baris di tabel, isikan data ke form
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int selected = table.getSelectedRow();
                if(selected >= 0){
                    txtUsername.setText(model.getValueAt(selected, 0).toString());
                    txtPassword.setText(model.getValueAt(selected, 1).toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormLogin().setVisible(true);
        });
    }
}
