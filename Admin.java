import java.util.Scanner;

public class Admin extends User {

    public Admin(String username, String password, String name) {
        super(username, password, name);
    }

    @Override
    public void displayDashboard() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Dashboard Admin: " + getName() + " ===");
            System.out.println("1. Kelola Anggota");
            System.out.println("2. Approve Pinjaman");
            System.out.println("3. Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    kelolaAnggota();
                    break;
                case 2:
                    approvePinjaman();
                    break;
                case 3:
                    lihatLaporan();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    private void kelolaAnggota() {
        System.out.println("[Menu] Kelola Anggota dijalankan...");
        // Logika kelola anggota di sini
    }

    private void approvePinjaman() {
        System.out.println("[Menu] Approve Pinjaman dijalankan...");
        // Logika approve pinjaman di sini
    }

    private void lihatLaporan() {
        System.out.println("[Menu] Melihat Laporan...");
        // Logika melihat laporan di sini
    }
}
