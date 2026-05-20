import java.util.Random;

class Pemasok implements Runnable{
    private Gudang gudang;
    private Random random = new Random();

    Pemasok(Gudang gudang){
        this.gudang = gudang;
    }

    public void run(){
        try{
             while (!Thread.currentThread().isInterrupted()) {
                    int jumlah = random.nextInt(5) + 1;

                    gudang.tambahStok(jumlah);
                    Thread.sleep((random.nextInt(2) + 1) * 1000);
            }
        }catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " dihentikan.");
        }
    }
}
