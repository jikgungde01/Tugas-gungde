// Kelas induk (superclass)
class Hewan {
    void makan() {
        System.out.println("Hewan sedang makan.");
    }
}

// Kelas anak (subclass) dari Hewan - Kucing
class Kucing extends Hewan {
    void suara() {
        System.out.println("Meow!");
    }
}

// Kelas anak (subclass) dari Hewan - Anjing
class Anjing extends Hewan {
    void suara() {
        System.out.println("Guk Guk!");
    }
}

// Main class untuk menjalankan program
public class Main3 {
    public static void main(String[] args) {
        // Membuat objek Kucing
        Kucing kucing1 = new Kucing();
        System.out.println("Objek Kucing:");
        kucing1.makan(); // Memanggil method dari superclass Hewan
        kucing1.suara(); // Memanggil method dari subclass Kucing

        System.out.println(); // Memberi jarak output

        // Membuat objek Anjing
        Anjing anjing1 = new Anjing();
        System.out.println("Objek Anjing:");
        anjing1.makan(); // Memanggil method dari superclass Hewan
        anjing1.suara(); // Memanggil method dari subclass Anjing
    }
}
