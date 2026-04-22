// Superclass
class Product {
    String Merek;
    int Nomor_Seri;
    double harga;

    public Product(String Merek, int Nomor_Seri, double harga) {
        this.Merek = Merek;
        this.Nomor_Seri = Nomor_Seri;
        this.harga = harga;
    }

    public void displayInfo() {
        System.out.println("Merek: " + Merek);
        System.out.println("Serial Number: " + Nomor_Seri);
        System.out.println("Price: $" + harga);
    }
}

// Subclass Smartphone
class Smartphone extends Product {
    double Ukuran_layar;
    int Kapasitas_Penyimpanan;

    public Smartphone(String Merek, int Nomor_Seri, double harga, double Ukuran_layar, int Kapasitas_Penyimpanan) {
        super(Merek, Nomor_Seri, harga);
        this.Ukuran_layar = Ukuran_layar;
        this.Kapasitas_Penyimpanan = Kapasitas_Penyimpanan;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + Ukuran_layar + " inches");
        System.out.println("Storage Capacity: " + Kapasitas_Penyimpanan + "GB");
        System.out.println();
    }
}

// Subclass Laptop
class Laptop extends Product {
    int Ukuran_Ram;
    String Tipe_prosessor;

    public Laptop(String Merek, int Nomor_Seri, double harga, int Ukuran_Ram, String Tipe_prosessor) {
        super(Merek, Nomor_Seri, harga);
        this.Ukuran_Ram = Ukuran_Ram;
        this.Tipe_prosessor = Tipe_prosessor;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Processor Type: " + Tipe_prosessor);
        System.out.println("RAM Size: " + Ukuran_Ram + "GB");
        System.out.println();
    }
}

// Subclass Camera
class Camera extends Product {
    int resolusi;
    String Jenis_Lensa;

    public Camera(String Merek, int Nomor_Seri, double harga, int resolusi, String Jenis_Lensa) {
        super(Merek, Nomor_Seri, harga);
        this.resolusi = resolusi;
        this.Jenis_Lensa = Jenis_Lensa;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("resolusi: " + resolusi + "MP");
        System.out.println("Lens Type: " + Jenis_Lensa);
        System.out.println();
    }
}

