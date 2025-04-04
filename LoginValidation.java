import java.util.Scanner;

public class LoginValidation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String validUsername = "admin";
        String validPassword = "password123";
        int attempts = 0;
        final int maxAttempts = 3;

        while (attempts < maxAttempts) {
            System.out.print("Masukkan username: ");
            String username = input.nextLine();

            System.out.print("Masukkan password: ");
            String password = input.nextLine();

            if (username.equals(validUsername) && password.equals(validPassword)) {
                System.out.println("Selamat datang, " + username + "!");
                return;
            } else {
                attempts++;
                System.out.println("Username atau password salah. Percobaan ke-" + attempts + " dari " + maxAttempts);
            }
        }

        System.out.println("Akun diblokir!");
        input.close();
    }
}
