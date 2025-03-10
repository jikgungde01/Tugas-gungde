// Abstract class Kendaraan
abstract class Kendaraan {
    protected String nama;
    protected int jumlahRoda;

    public Kendaraan(String nama, int jumlahRoda) {
        this.nama = nama;
        this.jumlahRoda = jumlahRoda;
    }

    // Method abstrak yang harus diimplementasikan oleh subclass
    public abstract void bergerak();
}

// Subclass Mobil
class Mobil extends Kendaraan {
    public Mobil(String nama) {
        super(nama, 4); // Mobil memiliki 4 roda
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " bergerak dengan empat roda.");
    }
}

// Subclass SepedaMotor
class SepedaMotor extends Kendaraan {
    public SepedaMotor(String nama) {
        super(nama, 2); // Sepeda motor memiliki 2 roda
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " bergerak dengan dua roda.");
    }
}

// Interface KendaraanListrik
interface KendaraanListrik {
    void isiDaya();
}

// Subclass MobilListrik yang merupakan subclass dari Mobil dan mengimplementasikan KendaraanListrik
class MobilListrik extends Mobil implements KendaraanListrik {
    public MobilListrik(String nama) {
        super(nama);
    }

    @Override
    public void isiDaya() {
        System.out.println(nama + " sedang mengisi daya.");
    }
}

// Kelas utama untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota");
        SepedaMotor motor = new SepedaMotor("Honda");
        MobilListrik tesla = new MobilListrik("Tesla Model S");

        mobil.bergerak();
        motor.bergerak();
        tesla.bergerak();
        tesla.isiDaya();
    }
}