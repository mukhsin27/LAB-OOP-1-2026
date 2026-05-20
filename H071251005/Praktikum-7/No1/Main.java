import java.util.concurrent.*;


public class Main {
    public static void main(String[] args)throws InterruptedException {
        Gudang gudang = new Gudang(20);

        ExecutorService pemasokPool = Executors.newFixedThreadPool(3);

        ExecutorService kurirPool = Executors.newFixedThreadPool(3);

        Thread monitoring = new Thread(new Monitoring(gudang));

        System.out.println("=================================");
        System.out.println("SISTEM LOGISTIK DIMULAI");
        System.out.println("=================================");

        for(int i = 1; i <= 2; i++){
            pemasokPool.execute(new Pemasok(gudang));
        }
        for(int i = 1;  i <= 3; i++){
            kurirPool.execute(new Kurir(gudang));
        }

        monitoring.start();

        Thread.sleep(15000);
        System.out.println("\n===============================");
        System.out.println("MENGHENTIKAN SISTEM");
        System.out.println("==================================");


        pemasokPool.shutdownNow();
        kurirPool.shutdownNow();

        monitoring.interrupt();

        pemasokPool.awaitTermination(5, TimeUnit.SECONDS);
        kurirPool.awaitTermination(5,TimeUnit.SECONDS);

         System.out.println("\n====================================");
        System.out.println("SEMUA THREAD SELESAI");
        System.out.println("====================================");

        


    }
}
