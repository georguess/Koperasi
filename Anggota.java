import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Dashboard Anggota: " + getName() + " ===");
            System.out.println("1. Lihat Saldo & Status");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    lihatSaldoDanStatus();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    private void lihatSaldoDanStatus() {
        System.out.println("\n--- Informasi Saldo & Status ---");
        System.out.println("Saldo Simpanan \t: Rp " + saldoSimpanan);
        System.out.println("Status Pinjaman\t: " + statusPinjaman);
        System.out.println("--------------------------------");
    }
}
