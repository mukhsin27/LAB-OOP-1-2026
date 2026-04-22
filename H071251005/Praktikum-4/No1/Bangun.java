class Bangun {
     String nama;

    Bangun(String nama) {
        this.nama = nama;
    }

    String getNama() {
        return nama;
    }
}

// ================= BANGUN DATAR =================
class BangunDatar extends Bangun {

    BangunDatar(String nama) {
        super(nama);
    }

    double luas() { return 0; }
    double keliling() { return 0; }
}

class Persegi extends BangunDatar {
    double sisi;

    Persegi(double sisi) {
        super("Persegi");
        this.sisi = sisi;
    }

    double luas() { return sisi * sisi; }
    double keliling() { return 4 * sisi; }
}

class PersegiPanjang extends BangunDatar {
    double p, l;

    PersegiPanjang(double p, double l) {
        super("Persegi Panjang");
        this.p = p;
        this.l = l;
    }

    double luas() { return p * l; }
    double keliling() { return 2 * (p + l); }
}

class Lingkaran extends BangunDatar {
    double r;

    Lingkaran(double r) {
        super("Lingkaran");
        this.r = r;
    }

    double luas() { return Math.PI * r * r; }
    double keliling() { return 2 * Math.PI * r; }
}

class Trapesium extends BangunDatar {
    double a, b, c, d, t;

    Trapesium(double a, double b, double c, double d, double t) {
        super("Trapesium");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.t = t;
    }

    double luas() { return 0.5 * (a + b) * t; }
    double keliling() { return a + b + c + d; }
}

// ================= BANGUN RUANG =================
class BangunRuang extends Bangun {

    BangunRuang(String nama) {
        super(nama);
    }

    double volume() { return 0; }
    double luasPermukaan() { return 0; }
}

class Kubus extends BangunRuang {
    double s;

    Kubus(double s) {
        super("Kubus");
        this.s = s;
    }

    double volume() { return s * s * s; }
    double luasPermukaan() { return 6 * s * s; }
}

class Balok extends BangunRuang {
    double p, l, t;

    Balok(double p, double l, double t) {
        super("Balok");
        this.p = p;
        this.l = l;
        this.t = t;
    }

    double volume() { return p * l * t; }
    double luasPermukaan() { return 2 * (p*l + p*t + l*t); }
}

class Bola extends BangunRuang {
    double r;

    Bola(double r) {
        super("Bola");
        this.r = r;
    }

    double volume() { return (4.0/3.0) * Math.PI * r * r * r; }
    double luasPermukaan() { return 4 * Math.PI * r * r; }
}

class Tabung extends BangunRuang {
    double r, t;

    Tabung(double r, double t) {
        super("Tabung");
        this.r = r;
        this.t = t;
    }

    double volume() { return Math.PI * r * r * t; }
    double luasPermukaan() { return 2 * Math.PI * r * (r + t); }
}