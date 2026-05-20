import java.util.Random;

class Kurir implements Runnable{
    private Gudang gudang;
    private Random random = new Random();

    Kurir(Gudang gudang){
        this.gudang = gudang;
    }
    public void run(){
       try{
        while (!Thread.currentThread().isInterrupted()) {
            int jumlah = random.nextInt(4) + 1;

            gudang.ambilStok(jumlah);

            Thread.sleep((random.nextInt(2) + 2) * 1000);
        }
       }catch(InterruptedException e){
        System.out.println(Thread.currentThread().getName() + " dihentikan");
       }
        
    }
}