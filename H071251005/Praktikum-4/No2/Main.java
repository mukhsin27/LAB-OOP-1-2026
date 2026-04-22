import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Product> daftarProduk = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print(">>> Pilih menu (1-4): ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahProduk();
                    break;
                case 2:
                    tampilkanProduk();
                    break;
                case 3:
                    beliProduk();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);
    }

    static void tambahProduk() {
        System.out.print("Masukkan nama produk: ");
        String brand = input.nextLine();

        System.out.print("Masukkan nomor seri: ");
        int serial = input.nextInt();

        System.out.print("Masukkan harga: ");
        double harga = input.nextDouble();

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Camera");
        System.out.print("Pilih tipe produk (1-3): ");
        int tipe = input.nextInt();

        if (tipe == 1) {
            System.out.print("Masukkan ukuran layar (inci): ");
            double layar = input.nextDouble();

            System.out.print("Masukkan kapasitas penyimpanan (GB): ");
            int storage = input.nextInt();

            daftarProduk.add(new Smartphone(brand, serial, harga, layar, storage));

        } else if (tipe == 2) {
            System.out.print("Masukkan RAM (GB): ");
            int ram = input.nextInt();
            input.nextLine();

            System.out.print("Masukkan tipe processor: ");
            String proc = input.nextLine();

            daftarProduk.add(new Laptop(brand, serial, harga, ram, proc));

        } else if (tipe == 3) {
            System.out.print("Masukkan resolusi (MP): ");
            int res = input.nextInt();
            input.nextLine();

            System.out.print("Masukkan tipe lensa: ");
            String lens = input.nextLine();

            daftarProduk.add(new Camera(brand, serial, harga, res, lens));
        }
    }

    static void tampilkanProduk() {
        System.out.println("Daftar Produk:");
        for (Product p : daftarProduk) {
            p.displayInfo();
        }
    }

    static void beliProduk() {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        int cari = input.nextInt();

        Product ditemukan = null;

        for (Product p : daftarProduk) {
            if (p.Nomor_Seri == cari) {
                ditemukan = p;
                break;
            }
        }

        if (ditemukan != null) {
            System.out.println("Anda telah membeli produk:");
            ditemukan.displayInfo();
        } else {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }
}