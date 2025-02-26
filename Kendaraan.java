// Definisi Kelas Kendaraan
public class Kendaraan {
    // Atribut
    private String merk;
    private String tipe;
    private int kecepatan;

    // Konstruktor untuk menginisialisasi atribut
    public Kendaraan(String merk, String tipe, int kecepatan) {
        this.merk = merk;
        this.tipe = tipe;
        this.kecepatan = kecepatan;
    }

    // Metode untuk menampilkan informasi kendaraan
    public void tampilkanInfo() {
        System.out.println("Merk: " + merk + ", Tipe: " + tipe + ", Kecepatan: " + kecepatan + " km/jam");
    }

    // Metode untuk menambah kecepatan kendaraan
    public void tambahKecepatan(int km) {
        if (km > 0) {
            kecepatan += km;
            System.out.println("Kecepatan bertambah " + km + " km/jam. Kecepatan sekarang: " + kecepatan + " km/jam.");
        } else {
            System.out.println("Nilai kecepatan harus lebih dari 0.");
        }
    }

    // Metode untuk mengurangi kecepatan kendaraan
    public void kurangiKecepatan(int km) {
        if (km > 0) {
            kecepatan -= km;
            if (kecepatan < 0) {
                kecepatan = 0;
            }
            System.out.println("Kecepatan berkurang " + km + " km/jam. Kecepatan sekarang: " + kecepatan + " km/jam.");
        } else {
            System.out.println("Nilai pengurangan harus lebih dari 0.");
        }
    }

    // Metode untuk menghentikan kendaraan
    public void berhenti() {
        kecepatan = 0;
        System.out.println("Kendaraan telah berhenti.");
    }
}

// Program Utama
public class mainKendaraan {
    public static void main(String[] args) {
        // Membuat objek Kendaraan
        Kendaraan mobil = new Kendaraan("Toyota", "Mobil", 80);
        Kendaraan motor = new Kendaraan("Honda", "Motor", 40);

        // Menampilkan informasi kendaraan1
        mobil.tampilkanInfo();
        mobil.tambahKecepatan(50);
        mobil.kurangiKecepatan(30);
        mobil.berhenti();
        mobil.tampilkanInfo();

        System.out.println(); // Pemisah output
        
        motor.tampilkanInfo();
        motor.tambahKecepatan(30);
        motor.kurangiKecepatan(40);
        motor.berhenti();
        motor.tampilkanInfo();
    }
}