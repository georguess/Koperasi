import javax.swing.*;
import java.awt.*;

public class Admin extends User {

    public Admin(String username, String password, String name) {
        super(username, password, name);
    }

    @Override
    public void displayDashboard() {
        JFrame frame = new JFrame("Dashboard Admin - " + getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnKelola = new JButton("Kelola Anggota");
        JButton btnApprove = new JButton("Approve Pinjaman");
        JButton btnLaporan = new JButton("Laporan");
        JButton btnLogout = new JButton("Logout");

        btnKelola.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Membuka menu Kelola Anggota..."));
        btnApprove.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Membuka menu Approve Pinjaman..."));
        btnLaporan.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Membuka menu Laporan..."));
        
        btnLogout.addActionListener(e -> {
            frame.dispose(); // Tutup window admin
            main.createAndShowLogin(); // Kembali ke panel login
        });

        panel.add(btnKelola);
        panel.add(btnApprove);
        panel.add(btnLaporan);
        panel.add(btnLogout);

        frame.add(panel);
        frame.setVisible(true);
    }
}

