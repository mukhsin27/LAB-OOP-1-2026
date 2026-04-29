class SmartLamp extends PerangkatElektronik implements KontrolSuara{

    SmartLamp(String merk, int dayaListrik){
        super(merk,dayaListrik);
    }

    @Override
    void cekFungsi(){
        System.out.println("Smart Lamp berfungsi untuk pencahayaan.");
    }


    @Override
    public void prosesPerintah(String perintah){

        if(perintah.equalsIgnoreCase("NYALA")){
            System.out.println("Lampu berpijar!");
        }
        else{
            System.out.println("Perintah tidak dikenali.");
        }

    }

}
