import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ulang;

        do {
            System.out.print("Masukkan angka pertama: ");
            double angka1 = input.nextDouble();

            System.out.print("Masukkan operator (+, -, *, /, %): ");
            char operator = input.next().charAt(0);

            System.out.print("Masukkan angka kedua: ");
            double angka2 = input.nextDouble();

            double hasil;
            boolean valid = true;

            switch (operator) {
                case '+':
                    hasil = angka1 + angka2;
                    break;
                case '-':
                    hasil = angka1 - angka2;
                    break;
                case '*':
                    hasil = angka1 * angka2;
                    break;
                case '/':
                    if (angka2 != 0) {
                        hasil = angka1 / angka2;
                    } else {
                        System.out.println("Error: Pembagian dengan nol!");
                        valid = false;
                        hasil = 0;
                    }
                    break;
                case '%':
                    hasil = angka1 % angka2;
                    break;
                default:
                    System.out.println("Operator tidak valid!");
                    valid = false;
                    hasil = 0;
            }

            if (valid) {
                System.out.println("Hasil: " + hasil);
            }

            System.out.print("Ingin menghitung lagi? (y/n): ");
            ulang = input.next().charAt(0);

        } while (ulang == 'y' || ulang == 'Y');

        System.out.println("Terima kasih telah menggunakan kalkulator.");
        input.close();
    }
}
