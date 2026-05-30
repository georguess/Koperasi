import java.util.Scanner;

public class Kasir extends User {

    public Kasir(String username, String password, String name) {
        super(username, password, name);
    }

    @Override
    public void displayDashboard() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Dashboard Kasir: " + getName() + " ===");
            System.out.println("1. Setor Simpanan");
            System.out.println("2. Terima Angsuran");
            System.out.println("3. Input Pengajuan Pinjaman");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    setorSimpanan();
                    break;
                case 2:
                    terimaAngsuran();
                    break;
                case 3:
                    inputPengajuanPinjaman();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    private void setorSimpanan() {
        System.out.println("[Menu] Form Setor Simpanan dibuka...");
        // Logika setor simpanan
    }

    private void terimaAngsuran() {
        System.out.println("[Menu] Form Terima Angsuran dibuka...");
        // Logika terima angsuran
    }

    private void inputPengajuanPinjaman() {
        System.out.println("[Menu] Form Input Pengajuan Pinjaman dibuka...");
        // Logika input pengajuan
    }
}
