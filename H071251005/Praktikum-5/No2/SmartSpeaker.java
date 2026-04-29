class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara{
    SmartSpeaker(String merk,int dayaListrik){
        super(merk,dayaListrik);
    }

    @Override
    void cekFungsi(){
        System.out.println("Smart Speaker memutar musik dan asisten suara.");
    }

    @Override
    public void hubungkanWiFi(){
        System.out.println("Speaker terhubung ke WiFi.");
    }

    @Override
    public void prosesPerintah(String perintah){

        if(perintah.equalsIgnoreCase("PLAY")){
            System.out.println("Memutar musik...");
        }

        else{
            System.out.println("Perintah tidak dikenal.");
        }

    }

}
