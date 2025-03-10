// Superclass
class Hewan {
    void bersuara() {
        System.out.println("Hewan bersuara...");
    }
}

// Subclass Kucing
class Kucing extends Hewan {
    @Override
    void bersuara() {
        System.out.println("Meow! Meow!");
    }
}

// Subclass Anjing
class Anjing extends Hewan {
    @Override
    void bersuara() {
        System.out.println("Guk! Guk!");
    }
}

// Main class untuk menjalankan program
public class Main7 {
    public static void main(String[] args) {
        // Polimorfisme: Variabel bertipe superclass tetapi berisi objek subclass
        Hewan hewan1 = new Kucing(); // Objek Kucing
        Hewan hewan2 = new Anjing(); // Objek Anjing

        // Memanggil metode bersuara(), akan menjalankan metode override di subclass masing-masing
        hewan1.bersuara(); // Output: Meow! Meow!
        hewan2.bersuara(); // Output: Guk! Guk!
    }
}
