import java.util.*;
import java.io.*;
import inti.*;

interface DataManagement {
    void tambah() throws IOException;
    void lihat() throws IOException;
    void ubah();
    void hapus();
    
    static void greetUser() {
        System.out.println("Welcome to Mamat Fish Store");
    }
    static void thanks() {
        System.out.println("Thanks For See My Program. Have A Nice Day!");
    }
}

public class App implements DataManagement {
    static ArrayList<Plakat> plk = new ArrayList<>();
    static ArrayList<HalfMoon> lfm = new ArrayList<>();
    static int percobaanGagal = 0;
    static int totalData = 0; // Variabel static untuk menyimpan jumlah total data
    static int jumlahTambahan = 0; // Variabel static untuk menyimpan jumlah data ikan yang ditambahkan
    // Atribut Final
    static final int BATAS_PERCOBAAN = 3;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DataManagement.greetUser();
        boolean berhasilLogin = false;
        while (!berhasilLogin && percobaanGagal < BATAS_PERCOBAAN) {  
            System.out.println("==================================================================================");
            System.out.println("|     Welcome To My Program Sistem Pendataan Ikan Cupang di Mamat Fish Store     |");
            System.out.println("==================================================================================");
            System.out.println("==================================================================================");
            System.out.println("|                                   LOGIN FORM                                   |");
            System.out.println("==================================================================================");
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            if (username.equals("wiki") && password.equals("048")) {
                berhasilLogin = true;
                System.out.println("==================================================================================");
                System.out.println("|                               You're logged in                                 |");
                System.out.println("==================================================================================");
            } else {
                percobaanGagal++;
                if (percobaanGagal < BATAS_PERCOBAAN) {
                    System.out.println("Login gagal. Silakan coba lagi.");
                } else {
                    System.out.println("Anda telah melebihi batas percobaan. Program berhenti.");
                    return; 
                }
            }
        }
        
        // clearScreen();
        App app = new App(); // membuat objek App
        while (true) {
            System.out.println("======================");
            System.out.println("||     MAIN MENU    ||");
            System.out.println("======================");
            System.out.println("|| 1. Tambah Data   ||");
            System.out.println("|| 2. Lihat Data    ||");
            System.out.println("|| 3. Ubah Data     ||");
            System.out.println("|| 4. Hapus data    ||");
            System.out.println("|| 5. Exit Program  ||");
            System.out.println("======================");
            // Menambahkan kode untuk menampilkan total data dan jumlah tambahan
            System.out.println("Total Data: " + (plk.size() + lfm.size()));
            System.out.println("Jumlah Tambahan: " + App.getJumlahTambahan());
            System.out.print("Pilihan : ");
            String pilih = sc.nextLine();
            if (pilih.equals("1")) {
                app.tambah(); // Memanggil method tambah melalui objek app
            } else if (pilih.equals("2")) {
                app.lihat(); // Memanggil method lihat melalui objek app
            } else if (pilih.equals("3")) {
                app.ubah(); // Memanggil method ubah melalui objek app
            } else if (pilih.equals("4")) {
                app.hapus(); // Memanggil method hapus melalui objek app
            } else if (pilih.equals("5")) {
                DataManagement.thanks();
                break;
            } else {
                System.out.println("pilih yang bener bro");
            }
        }       
    }


    @Override
    public void tambah() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=================================================");
        System.out.println("|           MENU TAMBAH DATA IKAN CUPANG        |");
        System.out.println("=================================================");
        System.out.println("| 1. Tambah Ikan Cupang Plakat                  |");
        System.out.println("| 2. Tambah Ikan Cupang HalfMoon                |");
        System.out.println("| 3. Kembali ke Menu Utama                      |");
        System.out.println("=================================================");
        System.out.print("Masukkan Pilihan : ");
        boolean inputValid = false;
        while (!inputValid) {
            String pilih = sc.nextLine();
            inputValid = true;
            try {
                if (pilih.equals("1")) {
                    System.out.println("=================================================");
                    System.out.println("|              MENU TAMBAH IKAN PLAKAT          |");
                    System.out.println("=================================================");
                    System.out.print("Masukkan ID Ikan    : ");
                    // Variable Final
                    final int idIkan = Integer.parseInt(sc.nextLine());
                    if (isIdExist(plk, idIkan)) {
                        System.out.println("pake ID yang belum kepake");
                        continue;
                    }
                    System.out.print("Masukkan Nama Ikan  : ");
                    String namaIkan = sc.nextLine();
                    System.out.print("Masukkan Warna Ikan : ");
                    String warnaIkan = sc.nextLine();
                    System.out.print("Masukkan Stok Ikan  : ");
                    int stokIkan = Integer.parseInt(sc.nextLine());
                    System.out.print("Masukkan harga Ikan : ");
                    double hargaIkan = Double.parseDouble(sc.nextLine());
                    Plakat dataIkan = new Plakat(idIkan, stokIkan, namaIkan, warnaIkan, hargaIkan);
                    plk.add(dataIkan);
                    jumlahTambahan++; // Menambah jumlah tambahan data ikan
                    System.out.println("=================================================");
                    System.out.println("|            You're data has been add           |");
                    System.out.println("=================================================");
                } else if (pilih.equals("2")) {
                    System.out.println("=================================================");
                    System.out.println("|            MENU TAMBAH IKAN HALFMOON          |");
                    System.out.println("=================================================");
                    System.out.print("Masukkan ID Ikan          : ");
                    int idIkan = Integer.parseInt(sc.nextLine());
                    System.out.print("Masukkan Nama Ikan        : ");
                    String namaIkan = sc.nextLine();
                    System.out.print("Masukkan Bentuk Ekor Ikan : ");
                    String bentukEkor = sc.nextLine();
                    System.out.print("Masukkan Stok Ikan        : ");
                    int stokIkan = Integer.parseInt(sc.nextLine());
                    System.out.print("Masukkan Harga Ikan       : ");
                    double hargaIkan = Double.parseDouble(sc.nextLine());
                    HalfMoon datHalfMoon = new HalfMoon(idIkan, stokIkan, namaIkan, bentukEkor, hargaIkan);
                    lfm.add(datHalfMoon);
                    jumlahTambahan++; // Menambah jumlah tambahan data ikan
                    System.out.println("=================================================");
                    System.out.println("|            You're data has been add           |");
                    System.out.println("=================================================");
                } else if (pilih.equals("3")) {
                    break;
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("kasih input angka aja cess");
                inputValid = false;
            }
        }
    }

    public static int getJumlahTambahan() {
        return jumlahTambahan;
    }

    @Override
    public void lihat() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==============================================");
            System.out.println("|        MENU LIHAT DATA IKAN CUPANG         |");
            System.out.println("==============================================");
            System.out.println("| 1. Ikan Cupang Plakat                      |");
            System.out.println("| 2. Ikan Cupang HalfMoon                    |");
            System.out.println("| 3. Kembali ke Menu Utama                   |");
            System.out.println("==============================================");
            System.out.print("Masukkan Pilihan : ");
            String pilih = sc.nextLine();
            if (pilih.equals("1")) {
                System.out.println("Data Ikan Cupang Plakat");
                if (plk.size() < 1) {
                    System.out.println("nihil");
                } else {
                    for (int i = 0; i < plk.size(); i++) {
                        System.out.println("-----------------------------------");
                        plk.get(i).display(i+1);
                    }
                }
                break;
            } else if (pilih.equals("2")) {
                System.out.println("Data Ikan Cupang Half Moon");
                if (lfm.size() < 1) {
                    System.out.println("nihil");
                } else {
                    for (int i = 0; i < lfm.size(); i++) {
                        System.out.println("-----------------------------------");
                        lfm.get(i).display();
                    }
                }
                break;
            } else if (pilih.equals("3")) {
                break;
            } else {
                System.out.println("pilih yang bener dek");
            }
        }
    }

    @Override
    public void ubah() {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("|        MENU UBAH DATA IKAN CUPANG        |");
        System.out.println("============================================");
        System.out.println("| 1. Ikan Cupang Plakat                    |");
        System.out.println("| 2. Ikan Cupang HalfMoon                  |");
        System.out.println("| 3. Kembali ke Menu Utama                 |");
        System.out.println("============================================");
        System.out.print("Masukkan Pilihan : ");
        String pilih = sc.nextLine();
        if (pilih.equals("1")) {
            System.out.println("Data Ikan Cupang Plakat");
            if (plk.size() < 1) {
                System.out.println("nihil");
            } else {
                for (int i = 0; i < plk.size(); i++) {
                    System.out.println("-----------------------------------");
                    System.out.println("Ikan ke " + (i + 1));
                    System.out.println("ID Ikan    : " + plk.get(i).getIdIkan());
                    System.out.println("Nama Ikan  : " + plk.get(i).getNamaIkan());
                    System.out.println("Warna Ikan : " + plk.get(i).getWarnaIkan());
                    System.out.println("Stok Ikan  : " + plk.get(i).getStokIkan());
                    System.out.println("Harga Ikan : " + plk.get(i).getHargaIkan());
                }
                System.out.print("Pilih Nomor untuk diubah: ");
                int index = sc.nextInt();
                sc.nextLine(); 
                try {
                    System.out.print("Masukkan ID Baru: ");
                    final int newId = Integer.parseInt(sc.nextLine());
                    System.out.print("Masukkan Nama Baru: ");
                    String newName = sc.nextLine();
                    System.out.print("Masukkan Warna Baru: ");
                    String newColor = sc.nextLine();
                    System.out.print("Masukkan Stok Baru: ");
                    int newStock = Integer.parseInt(sc.nextLine());
                    System.out.print("Masukkan Harga Baru: ");
                    double newPrice = Double.parseDouble(sc.nextLine());
                    plk.get(index - 1).setIdIkan(newId);
                    plk.get(index - 1).setNamaIkan(newName);
                    plk.get(index - 1).setWarnaIkan(newColor);
                    plk.get(index - 1).setStokIkan(newStock);
                    plk.get(index - 1).setHargaIkan(newPrice);
                    System.out.println("Data berhasil diubah.");
                } catch (NumberFormatException e) {
                    System.out.println("Input harus berupa angka untuk ID Ikan, Stok Ikan, dan Harga Ikan.");
                }
            }
        } else if (pilih.equals("2")) {
            System.out.println("Data Ikan Cupang Half Moon");
            if (lfm.size() < 1) {
                System.out.println("Data Kosong");
            } else {
                for (int i = 0; i < lfm.size(); i++) {
                    System.out.println("-----------------------------------");
                    System.out.println("Ikan ke " + (i + 1));
                    System.out.println("ID Ikan     : " + lfm.get(i).getIdIkan());
                    System.out.println("Nama Ikan   : " + lfm.get(i).getNamaIkan());
                    System.out.println("Bentuk Ekor : " + lfm.get(i).getBentukEkor());
                    System.out.println("Stok Ikan   : " + lfm.get(i).getStokIkan());
                    System.out.println("Harga Ikan  : " + lfm.get(i).getHargaIkan());
                }
                System.out.print("Pilih Nomor untuk diubah: ");
                int index = sc.nextInt();
                sc.nextLine(); 
                try {
                    System.out.print("Masukkan ID Baru: ");
                    final int newId = Integer.parseInt(sc.nextLine());
                    System.out.print("Masukkan Nama Baru: ");
                    String newName = sc.nextLine();
                    System.out.print("Masukkan Bentuk Ekor Baru: ");
                    String newTailShape = sc.nextLine();
                    System.out.print("Masukkan Stok Baru: ");
                    int newStock = Integer.parseInt(sc.nextLine());
                    System.out.print("Masukkan Harga Baru: ");
                    double newPrice = Double.parseDouble(sc.nextLine());
                    lfm.get(index - 1).setIdIkan(newId);
                    lfm.get(index - 1).setNamaIkan(newName);
                    lfm.get(index - 1).setBentukEkor(newTailShape);
                    lfm.get(index - 1).setStokIkan(newStock);
                    lfm.get(index - 1).setHargaIkan(newPrice);
                    System.out.println("Data berhasil diubah.");
                } catch (NumberFormatException e) {
                    System.out.println("kasih input angka aja cess");
                }
            }
        }
    }

    @Override
    public void hapus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("|       MENU HAPUS DATA IKAN CUPANG        |");
        System.out.println("============================================");
        System.out.println("| 1. Ikan Cupang Plakat                    |");
        System.out.println("| 2. Ikan Cupang HalfMoon                  |");
        System.out.println("============================================");
        System.out.print("Masukkan Pilihan : ");
        String pilih = sc.nextLine();
        if (pilih.equals("1")) {
            System.out.println("Data Ikan Cupang Plakat");
            if (plk.size() < 1) {
                System.out.println("Data Kosong");
            } else {
                for (int i = 0; i < plk.size(); i++) {
                    System.out.println("-----------------------------------");
                    System.out.println("Ikan ke " + (i + 1));
                    System.out.println("ID Ikan    : " + plk.get(i).getIdIkan());
                    System.out.println("Nama Ikan  : " + plk.get(i).getNamaIkan());
                    System.out.println("Warna Ikan : " + plk.get(i).getWarnaIkan());
                    System.out.println("Stok Ikan  : " + plk.get(i).getStokIkan());
                    System.out.println("Harga Ikan : " + plk.get(i).getHargaIkan());
                }
                System.out.print("Pilih Nomor : ");
                int hapus = sc.nextInt();
                plk.remove(hapus - 1);
            }
        } else if (pilih.equals("2")) {
            System.out.println("Data Ikan Cupang Half Moon");
            if (lfm.size() < 1) {
                System.out.println("Data Kosong");
            } else {
                for (int i = 0; i < lfm.size(); i++) {
                    System.out.println("-----------------------------------");
                    System.out.println("Ikan ke " + (i + 1));
                    System.out.println("ID Ikan     : " + lfm.get(i).getIdIkan());
                    System.out.println("Nama Ikan   : " + lfm.get(i).getNamaIkan());
                    System.out.println("Bentuk Ekor : " + lfm.get(i).getBentukEkor());
                    System.out.println("Stok Ikan   : " + lfm.get(i).getStokIkan());
                    System.out.println("Harga Ikan  : " + lfm.get(i).getHargaIkan());
                }
                System.out.print("Pilih Nomor : ");
                int hapus = sc.nextInt();
                lfm.remove(hapus - 1);
            }
        }
    }

    public static boolean isIdExist(ArrayList<Plakat> list, int id) {
        for (Plakat plakat : list) {
            if (plakat.getIdIkan() == id) {
                return true;
            }
        }
        return false;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
