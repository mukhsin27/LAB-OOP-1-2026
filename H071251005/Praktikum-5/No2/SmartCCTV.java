class SmartCCTV extends PerangkatElektronik implements InteraksiInternet{

    SmartCCTV(String merk,int dayaListrik){
        super(merk,dayaListrik);
    }

    @Override
    void cekFungsi(){
        System.out.println("CCTV berfungsi untuk keamanan.");
    }

    @Override
    public void hubungkanWiFi(){
        System.out.println("Mengirim data ke server...");
    }


}