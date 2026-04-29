abstract class PerangkatElektronik {
    String merk;
    int dayaListrik;

    PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    abstract void cekFungsi();

    void infoPower() {
        System.out.println(merk +" sedang menyedot daya sebesar "+ dayaListrik + " Watt");
    }
}
