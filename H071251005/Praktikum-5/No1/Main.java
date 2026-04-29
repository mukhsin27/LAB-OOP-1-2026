public class Main {
    public static void main(String[] args) {

        KaryawanTetap kt = new KaryawanTetap("Andi", "K001", 5000000, 50000);
        for(int i=1; i<=22; i++){
            kt.absen();
        }
        double bonus = 1000000;

        System.out.println("=== Karyawan Tetap ===");
        System.out.println("Nama : " + kt.getNama());
        System.out.println("Kehadiran : " + kt.getJumlahKehadiran());
        System.out.println("Total Gaji + Bonus : Rp" + kt.hitungGaji(bonus));



        KaryawanKontrak kk = new KaryawanKontrak("Budi","K002",150000);
        for(int i=1; i<=23; i++){
            kk.absen();
        }

        System.out.println("\n=== Karyawan Kontrak ===");
        System.out.println("Nama : " + kk.getNama());
        System.out.println("Kehadiran : " + kk.getJumlahKehadiran());
        System.out.println("Total Gaji : Rp" + kk.hitungGaji());



    }
}
