import javax.swing.*;
import java.awt.*;

public class Kasir extends User {

    public Kasir(String username, String password, String name) {
        super(username, password, name);
    }

    @Override
    public void displayDashboard() {
        JFrame frame = new JFrame("Dashboard Kasir - " + getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnSetor = new JButton("Setor Simpanan");
        JButton btnAngsuran = new JButton("Terima Angsuran");
        JButton btnPinjaman = new JButton("Input Pengajuan Pinjaman");
        JButton btnLogout = new JButton("Logout");

        btnSetor.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Membuka form Setor Simpanan..."));
        btnAngsuran.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Membuka form Terima Angsuran..."));
        btnPinjaman.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Membuka form Input Pengajuan Pinjaman..."));
        
        btnLogout.addActionListener(e -> {
            frame.dispose(); // Tutup window kasir
            main.createAndShowLogin(); // Kembali ke panel login
        });

        panel.add(btnSetor);
        panel.add(btnAngsuran);
        panel.add(btnPinjaman);
        panel.add(btnLogout);

        frame.add(panel);
        frame.setVisible(true);
    }
}

