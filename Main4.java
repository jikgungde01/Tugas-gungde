// Interface Hewan
interface Hewan {
    void makan();
}

// Interface Mamalia
interface Mamalia {
    void menyusui();
}

// Kelas Kucing mengimplementasikan kedua interface
class Kucing implements Hewan, Mamalia {
    public void makan() {
        System.out.println("Kucing makan ikan.");
    }

    public void menyusui() {
        System.out.println("Kucing menyusui anaknya.");
    }
}

// Main class untuk menjalankan program
public class Main4 {
    public static void main(String[] args) {
        // Membuat objek Kucing
        Kucing kucing1 = new Kucing();
        
        // Memanggil method dari interface Hewan dan Mamalia
        System.out.println("Objek Kucing:");
        kucing1.makan();      // Dari interface Hewan
        kucing1.menyusui();   // Dari interface Mamalia
    }
}
