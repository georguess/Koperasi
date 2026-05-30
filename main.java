import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        initData();
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==================================");
            System.out.println("  SISTEM INFORMASI KOPERASI v1.0 ");
            System.out.println("==================================");
            System.out.print("Username (atau ketik 'exit'): ");
            String username = scanner.nextLine();
            
            if(username.equalsIgnoreCase("exit")) {
                System.out.println("Terima kasih telah menggunakan sistem ini.");
                break;
            }

            System.out.print("Password: ");
            String password = scanner.nextLine();

            User loggedInUser = authenticate(username, password);

            if (loggedInUser != null) {
                System.out.println("\nLogin Berhasil! Selamat datang, " + loggedInUser.getName());
                // Konsep Polimorfisme: Memanggil displayDashboard() yang sesuai 
                // dengan class aktual dari object (Admin / Kasir / Anggota)
                loggedInUser.displayDashboard(); 
            } else {
                System.out.println("\nLogin Gagal! Username atau password salah.");
            }
        }
        scanner.close();
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
        return null; // Return null jika login gagal
    }
}

