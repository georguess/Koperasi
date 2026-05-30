import javax.swing.*;
import java.awt.*;

public class Anggota extends User {

    private double saldoSimpanan;
    private String statusPinjaman;

    public Anggota(String username, String password, String name) {
        super(username, password, name);
        this.saldoSimpanan = 0.0;
        this.statusPinjaman = "Tidak ada pinjaman aktif";
    }

    @Override
    public void displayDashboard() {
        JFrame frame = new JFrame("Dashboard Anggota - " + getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnInfo = new JButton("Lihat Saldo & Status");
        JButton btnLogout = new JButton("Logout");

        btnInfo.addActionListener(e -> {
            String info = "Saldo Simpanan : Rp " + saldoSimpanan + "\n" +
                          "Status Pinjaman : " + statusPinjaman;
            JOptionPane.showMessageDialog(frame, info, "Informasi Saldo & Status", JOptionPane.INFORMATION_MESSAGE);
        });

        btnLogout.addActionListener(e -> {
            frame.dispose(); // Tutup window Anggota
            main.createAndShowLogin(); // Kembali ke panel login
        });

        panel.add(btnInfo);
        panel.add(btnLogout);

        frame.add(panel);
        frame.setVisible(true);
    }
}

