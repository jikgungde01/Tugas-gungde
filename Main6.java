// Kelas Kalkulator
class Kalkulator {

    // Metode pertama: Menjumlahkan dua angka (Overloading)
    int tambah(int a, int b) {
        return a + b;
    }

    // Metode kedua: Menjumlahkan tiga angka (Overloading)
    int tambah(int a, int b, int c) {
        return a + b + c;
    }

    // Metode ketiga: Menjumlahkan dua angka desimal (Overloading)
    double tambah(double a, double b) {
        return a + b;
    }
}

// Main class untuk menjalankan program
public class Main6 {
    public static void main(String[] args) {
        // Membuat objek Kalkulator
        Kalkulator k = new Kalkulator();

        // Memanggil metode tambah dengan berbagai parameter
        System.out.println("Hasil penjumlahan dua angka: " + k.tambah(5, 10));        // Memanggil metode pertama
        System.out.println("Hasil penjumlahan tiga angka: " + k.tambah(5, 10, 15));   // Memanggil metode kedua
        System.out.println("Hasil penjumlahan dua angka desimal: " + k.tambah(5.5, 2.5)); // Memanggil metode ketiga
    }
}
