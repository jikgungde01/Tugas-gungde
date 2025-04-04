import java.util.Random;
import java.util.Scanner;

public class TebakAngka {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int angkaRahasia = rand.nextInt(100) + 1; // angka 1 - 100
        int tebakan;
        int jumlahPercobaan = 0;

        System.out.println("Selamat datang di permainan Tebak Angka!");
        System.out.println("Saya telah memilih angka antara 1 hingga 100.");
        System.out.println("Coba tebak! (Ketik 0 untuk keluar)");

        while (true) {
            System.out.print("Masukkan tebakanmu: ");
            tebakan = input.nextInt();

            if (tebakan == 0) {
                System.out.println("Permainan dihentikan. Angka rahasia adalah: " + angkaRahasia);
                break;
            }

            jumlahPercobaan++;

            if (tebakan < angkaRahasia) {
                System.out.println("Terlalu kecil!");
            } else if (tebakan > angkaRahasia) {
                System.out.println("Terlalu besar!");
            } else {
                System.out.println("Selamat! Kamu berhasil menebak angka " + angkaRahasia +
                                   " dalam " + jumlahPercobaan + " percobaan.");
                break;
            }
        }

        input.close();
    }
}
