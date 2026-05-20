class Gudang{
    private int stok = 0;
    private final int kapasitasMaksimal;
    
    Gudang(int kapasitasMaksimal){
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public int getStok(){
        return stok;
    }

    public int getKapasitasMaksimal(){
        return kapasitasMaksimal;
    } 

    public synchronized void tambahStok(int jumlah)throws InterruptedException{
        while(stok + jumlah > kapasitasMaksimal){
            System.out.println(Thread.currentThread().getName() + " menunggu, gudang penuh");
            wait();
        }
        stok += jumlah;
        System.out.println(Thread.currentThread().getName() + " menambah " + jumlah + " barang | Stok sekarang: " + stok);
        notifyAll();

    }
    public synchronized void ambilStok(int jumlah)throws InterruptedException{
        while (stok < jumlah) {
           System.out.println(Thread.currentThread().getName() + " menunggu, stok kosong.....");
           wait();
        }
        stok -= jumlah;
        System.out.println(Thread.currentThread().getName() + " mengambil " + jumlah + " | stok sekarang: " + stok);
        notifyAll();
    
    
}

}