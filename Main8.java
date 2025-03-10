// Interface Kendaraan
interface Kendaraan {
    void berjalan();
}

// Implementasi pertama: Mobil
class Mobil implements Kendaraan {
    @Override
    public void berjalan() {
        System.out.println("Mobil berjalan dengan roda 4.");
    }
}

// Implementasi kedua: Motor
class Motor implements Kendaraan {
    @Override
    public void berjalan() {
        System.out.println("Motor berjalan dengan roda 2.");
    }
}

// Main class untuk menjalankan program
public class Main8 {
    public static void main(String[] args) {
        // Polimorfisme: Objek bertipe interface diisi dengan instance dari kelas yang mengimplementasikan interface
        Kendaraan kendaraan1 = new Mobil();
        Kendaraan kendaraan2 = new Motor();

        // Memanggil metode berjalan() sesuai implementasi masing-masing
        kendaraan1.berjalan(); // Output: Mobil berjalan dengan roda 4.
        kendaraan2.berjalan(); // Output: Motor berjalan dengan roda 2.
    }
}
