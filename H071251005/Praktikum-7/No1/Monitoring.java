
class Monitoring implements Runnable{
    private final Gudang gudang;
   
    Monitoring(Gudang gudang){
        this.gudang = gudang;
    }

    @Override
    public void run(){
        try{
            while (!Thread.currentThread().isInterrupted()) {
                int stok = gudang.getStok();

                int kapasitas = gudang.getKapasitasMaksimal();
                int pesen = (stok * 100) / kapasitas;

                int totalBar = 20;
                int filled = (stok * totalBar) / kapasitas;

                StringBuilder bar = new StringBuilder();
                for(int i = 0; i < filled; i++){
                    bar.append("#");
                }
                for(int i = filled; i < totalBar; i++){
                    bar.append("-");
                }
                System.out.println("\nStatus Gudang: [" + bar + "] " + pesen + "%\n");
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("Monitoring dihentikan");
        }
        
    }
}