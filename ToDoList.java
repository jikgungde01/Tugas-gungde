import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> tugas = new ArrayList<>();
        int pilihan;

        do {
            System.out.println("\n=== MENU TO-DO LIST ===");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Lihat Semua Tugas");
            System.out.println("3. Hapus Tugas");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan tugas baru: ");
                    String tugasBaru = input.nextLine();
                    tugas.add(tugasBaru);
                    System.out.println("Tugas berhasil ditambahkan!");
                    break;

                case 2:
                    if (tugas.isEmpty()) {
                        System.out.println("Daftar tugas kosong!");
                    } else {
                        System.out.println("\nDaftar Tugas:");
                        for (int i = 0; i < tugas.size(); i++) {
                            System.out.println((i + 1) + ". " + tugas.get(i));
                        }
                    }
                    break;

                case 3:
                    if (tugas.isEmpty()) {
                        System.out.println("Tidak ada tugas yang bisa dihapus!");
                    } else {
                        System.out.print("Masukkan nomor tugas yang ingin dihapus: ");
                        int index = input.nextInt();
                        if (index > 0 && index <= tugas.size()) {
                            tugas.remove(index - 1);
                            System.out.println("Tugas berhasil dihapus!");
                        } else {
                            System.out.println("Nomor tugas tidak valid!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Keluar dari program. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        } while (pilihan != 4);

        input.close();
    }
}
