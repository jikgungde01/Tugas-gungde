// Abstract class Kendaraan
abstract class Kendaraan {
    // Atribut nama dan jumlahRoda
    protected String nama;
    protected int jumlahRoda;

    // Constructor
    public Kendaraan(String nama, int jumlahRoda) {
        this.nama = nama;
        this.jumlahRoda = jumlahRoda;
    }

    // Method abstrak bergerak
    public abstract void bergerak();
}

// Subclass Mobil yang mengimplementasikan method bergerak
class Mobil extends Kendaraan {
    public Mobil(String nama, int jumlahRoda) {
        super(nama, jumlahRoda);
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " berjalan dengan mesin mobil.");
    }
}

// Subclass SepedaMotor yang mengimplementasikan method bergerak
class SepedaMotor extends Kendaraan {
    public SepedaMotor(String nama, int jumlahRoda) {
        super(nama, jumlahRoda);
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " berjalan dengan mesin sepeda motor.");
    }
}

// Interface KendaraanListrik
interface KendaraanListrik {
    void isiDaya();
}

// Kelas MobilListrik yang merupakan subclass dari Mobil dan juga mengimplementasikan KendaraanListrik
class MobilListrik extends Mobil implements KendaraanListrik {
    public MobilListrik(String nama, int jumlahRoda) {
        super(nama, jumlahRoda);
    }

    // Implementasi method bergerak dari kelas Mobil
    @Override
    public void bergerak() {
        System.out.println(nama + " berjalan dengan tenaga listrik.");
    }

    // Implementasi method isiDaya dari interface KendaraanListrik
    @Override
    public void isiDaya() {
        System.out.println(nama + " sedang mengisi daya.");
    }
}

// Main class harus memiliki nama yang sama dengan nama file (AbstractDemo.java)
public class AbstractDemo {
    public static void main(String[] args) {
        // Membuat objek kendaraan
        Kendaraan mobil = new Mobil("Mobil Sedan", 4);
        Kendaraan sepedaMotor = new SepedaMotor("Motor Sport", 2);
        MobilListrik mobilListrik = new MobilListrik("Mobil Listrik", 4);

        // Memanggil method bergerak untuk setiap kendaraan
        mobil.bergerak();
        sepedaMotor.bergerak();
        mobilListrik.bergerak();

        // Memanggil method isiDaya untuk kendaraan listrik
        mobilListrik.isiDaya();
    }
}
