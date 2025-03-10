// Kelas induk (superclass)
class Hewan {
    String nama;

    // Konstruktor kelas Hewan
    Hewan(String nama) {
        this.nama = nama;
    }

    // Method untuk menampilkan informasi hewan
    void info() {
        System.out.println("Nama: " + nama);
    }
}

// Kelas anak (subclass) dari Hewan - Kucing
class Kucing extends Hewan {
    // Konstruktor kelas Kucing
    Kucing(String nama) {
        super(nama); // Memanggil konstruktor superclass Hewan
    }
}

// Main class untuk menjalankan program
public class Main5 {
    public static void main(String[] args) {
        // Membuat objek Kucing
        Kucing kucing1 = new Kucing("Tom");

        // Memanggil method info() dari superclass Hewan
        System.out.println("Objek Kucing:");
        kucing1.info();
    }
}
