import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("====== BANGUN RUANG ======");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");

        System.out.println("\n====== BANGUN DATAR ======");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("----------------------------------------");

        System.out.print("Pilihan: ");
        int pilih = input.nextInt();

        System.out.println("----------------------------------------");

        BangunDatar bd = null;
        BangunRuang br = null;

        switch (pilih) {

            case 1:
                System.out.print("Masukkan sisi kubus: ");
                double s = input.nextDouble();
                br = new Kubus(s);
                break;

            case 2:
                System.out.print("Masukkan panjang balok: ");
                double p = input.nextDouble();
                System.out.print("Masukkan lebar balok: ");
                double l = input.nextDouble();
                System.out.print("Masukkan tinggi balok: ");
                double t = input.nextDouble();
                br = new Balok(p, l, t);
                break;

            case 3:
                System.out.print("Masukkan jari-jari bola: ");
                double Bola = input.nextDouble();
                br = new Bola(Bola);
                break;

            case 4:
                System.out.print("Masukkan jari-jari tabung: ");
                double rTabung = input.nextDouble();
                System.out.print("Masukkan tinggi tabung: ");
                double tTabung = input.nextDouble();
                br = new Tabung(rTabung, tTabung);
                break;

            case 5:
                System.out.print("Masukkan sisi persegi: ");
                double sisi = input.nextDouble();
                bd = new Persegi(sisi);
                break;

            case 6:
                System.out.print("Masukkan panjang persegi panjang: ");
                double pp = input.nextDouble();
                System.out.print("Masukkan lebar persegi panjang: ");
                double lp = input.nextDouble();
                bd = new PersegiPanjang(pp, lp);
                break;

            case 7:
                System.out.print("Masukkan jari-jari lingkaran: ");
                double rLingkaran = input.nextDouble();
                bd = new Lingkaran(rLingkaran);
                break;

            case 8:
                System.out.print("Masukkan sisi 1 trapesium: ");
                double a = input.nextDouble();
                System.out.print("Masukkan sisi 2 trapesium: ");
                double b = input.nextDouble();
                System.out.print("Masukkan sisi 3 trapesium: ");
                double c = input.nextDouble();
                System.out.print("Masukkan sisi 4 trapesium: ");
                double d = input.nextDouble();
                System.out.print("Masukkan tinggi trapesium: ");
                double tg = input.nextDouble();
                bd = new Trapesium(a, b, c, d, tg);
                break;

            default:
                System.out.println("Pilihan tidak tersedia");
        }

        System.out.println("----------------------------------------");

        if (bd != null) {
            System.out.println("Bangun datar: " + bd.getNama());
            System.out.println("Luas " + bd.getNama().toLowerCase() + ": " + bd.luas());
            System.out.println("Keliling " + bd.getNama().toLowerCase() + ": " + bd.keliling());
        } else if (br != null) {
            System.out.println("Bangun ruang: " + br.getNama());
            System.out.println("Volume " + br.getNama().toLowerCase() + ": " + br.volume());
            System.out.println("Luas permukaan " + br.getNama().toLowerCase() + ": " + br.luasPermukaan());
        }

        System.out.println("----------------------------------------");
         
        input.close();
    }
 }


