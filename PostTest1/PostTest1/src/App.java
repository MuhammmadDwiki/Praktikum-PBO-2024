import java.util.ArrayList;
import java.util.Scanner;
import inti.Ikan;

public class App {
    private static ArrayList<Ikan> daftarIkan = new ArrayList<>();
    private static int idCounter = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static final String adminUser = "wiki";
    private static final String adminPass = "048";
    private static final int Logal = 3;

    public static void main(String[] args) {
        int loginAttempts = 0;
        while (loginAttempts < Logal) {
            if (login()) {
                boolean run = true;
                while (run) {
                    System.out.println("\nMenu:");
                    System.out.println("1. Tambah Data");
                    System.out.println("2. Tampilkan Data");
                    System.out.println("3. Edit Data");
                    System.out.println("4. Hapus Data");
                    System.out.println("5. Keluar");

                    int pilih = getInput("Pilih menu: ");
                    if (pilih == 1) {
                        tambahData();
                    } else if (pilih == 2) {
                        tampilkanData();
                    } else if (pilih == 3) {
                        editData();
                    } else if (pilih == 4) {
                        hapusData();
                    } else if (pilih == 5) {
                        run = false;
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }
                break; // Keluar dari loop login setelah berhasil login
            } else {
                loginAttempts++;
                System.out.println("Login gagal. Sisa percobaan: " + (Logal - loginAttempts));
            }
        }
        if (loginAttempts == Logal) {
            System.out.println("Percobaan login melebihi batas. Program berhenti.");
        }
    }

    private static boolean login() {
        System.out.println("=== Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        return username.equals(adminUser) && password.equals(adminPass);
    }

    private static void tambahData() {
        System.out.println("\nTambah Data Ikan");

        String nama = getInputString("Masukkan nama ikan: ");
        String jenis = getInputString("Masukkan jenis ikan: ");
        double harga = getInputDouble("Masukkan harga ikan: ");
        int stok = getInput("Masukkan stok ikan: ");

        Ikan ikan = new Ikan(idCounter++, stok, nama, jenis, harga);
        daftarIkan.add(ikan);

        System.out.println("Data berhasil ditambahkan.");
    }

    private static void tampilkanData() {
        System.out.println("\nDaftar Ikan:");
        if (daftarIkan.isEmpty()) {
            System.out.println("Belum ada data ikan.");
        } else {
            for (Ikan ikan : daftarIkan) {
                ikan.tampil();
            }
        }
    }

    private static void editData() {
        System.out.println("\nEdit Data Ikan");

        int id = getInput("Masukkan ID ikan yang akan di edit: ");
        Ikan ikan = cariIkan(id);
        if (ikan != null) {
            String nama = getInputString("Masukkan nama baru ikan: ");
            String jenis = getInputString("Masukkan jenis baru ikan: ");
            double harga = getInputDouble("Masukkan harga baru ikan: ");
            int stok = getInput("Masukkan stok baru ikan: ");
            ikan.setNamaIkan(nama);
            ikan.setJenisIkan(jenis);
            ikan.setHargaIkan(harga);
            ikan.setStokIkan(stok);
            System.out.println("Data berhasil diubah.");
        } else {
            System.out.println("ID tidak ditemukan.");
        }
    }

    private static void hapusData() {
        System.out.println("\nHapus Data Ikan");

        int id = getInput("Masukkan ID ikan yang akan dihapus: ");
        Ikan ikan = cariIkan(id);
        if (ikan != null) {
            daftarIkan.remove(ikan);
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("ID tidak ditemukan.");
        }
    }

    private static Ikan cariIkan(int id) {
        for (Ikan ikan : daftarIkan) {
            if (ikan.getIdIkan() == id) {
                return ikan;
            }
        }
        return null;
    }

    private static int getInput(String prompt) {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Input harus berupa bilangan bulat.");
                scanner.nextLine(); // clear buffer
            }
        }
        return input;
    }

    private static double getInputDouble(String prompt) {
        double input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextDouble();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Input harus berupa angka.");
                scanner.nextLine(); // clear buffer
            }
        }
        return input;
    }

    private static String getInputString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
