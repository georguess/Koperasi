import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class main {
    private static List<User> users = new ArrayList<>();
    private static JFrame loginFrame;

    public static void main(String[] args) {
        initData();
        
        SwingUtilities.invokeLater(() -> {
            createAndShowLogin();
        });
    }

    private static void initData() {
        // Data Dummy untuk masing-masing role
        users.add(new Admin("admin", "admin123", "Budi (Admin Utama)"));
        users.add(new Kasir("kasir", "kasir123", "Siti (Kasir 1)"));
        users.add(new Anggota("anggota", "anggota123", "Fadhel (Anggota Reguler)"));
    }

    private static User authenticate(String username, String password) {
        for (User user : users) {
             if (user.login(username, password)) {
                 return user;
             }
        }
        return null;
    }

    public static void createAndShowLogin() {
        if (loginFrame != null) {
            loginFrame.setVisible(true);
            return;
        }

        loginFrame = new JFrame("Login Sistem Koperasi");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(350, 250);
        loginFrame.setLocationRelativeTo(null); // Center screen di tengah

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel userPanel = new JPanel(new BorderLayout(10, 10));
        userPanel.add(new JLabel("Username:"), BorderLayout.WEST);
        JTextField userField = new JTextField();
        userPanel.add(userField, BorderLayout.CENTER);

        JPanel passPanel = new JPanel(new BorderLayout(10, 10));
        passPanel.add(new JLabel("Password:"), BorderLayout.WEST);
        JPasswordField passField = new JPasswordField();
        passPanel.add(passField, BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");

        panel.add(new JLabel("SISTEM INFORMASI KOPERASI", SwingConstants.CENTER));
        panel.add(userPanel);
        panel.add(passPanel);
        panel.add(loginButton);

        loginFrame.add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                
                User loggedInUser = authenticate(username, password);
                if(loggedInUser != null) {
                    JOptionPane.showMessageDialog(loginFrame, "Login Berhasil! Selamat datang, " + loggedInUser.getName());
                    loginFrame.setVisible(false);
                    userField.setText("");
                    passField.setText("");
                    
                    loggedInUser.displayDashboard(); // Menjalankan GUI Dashboard masing-masing role
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Login Gagal. Username atau Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginFrame.setVisible(true);
    }
}


