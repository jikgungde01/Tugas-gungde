class Hewan {
// Atribut
String nama;
String jenis;
int umur;

// Konstruktor
Hewan(String nama, String jenis, int umur) {
this.nama = nama;
this.jenis = jenis;
this.umur = umur;
}

// Metode untuk menampilkan informasi hewan
void tampilkanInfo() {
System.out.println("Nama: " + nama + ", Jenis: " + jenis + ", Umur:
" + umur + " tahun");
}

// Metode untuk menambah umur hewan
void bertambahUmur(int tahun) {
this.umur += tahun;
System.out.println(nama + " telah bertambah umur menjadi " + umur +
" tahun.");
}

// Metode untuk menampilkan suara hewan
void suaraHewan() {
if (nama.equalsIgnoreCase("Kucing")) {
System.out.println(nama + ": Meong!");
} else if (nama.equalsIgnoreCase("Anjing")) {
System.out.println(nama + ": Guk guk!");
} else {
System.out.println(nama + ": Suara tidak diketahui.");
}

}
}

public class hewan {

/**
* @param args the command line arguments
*/
public static void main(String[] args) {
// Membuat objek Hewan
Hewan hewan1 = new Hewan("Kucing", "Mamalia", 3);
Hewan hewan2 = new Hewan("Anjing", "Mamalia", 2);

// Menampilkan informasi awal
hewan1.tampilkanInfo();
hewan1.suaraHewan();
hewan1.bertambahUmur(2); // Menambah umur kucing
hewan1.tampilkanInfo(); // Menampilkan info setelah umur bertambah

System.out.println(); // Pemisah output

hewan2.tampilkanInfo();
hewan2.suaraHewan();
hewan2.bertambahUmur(2); // Menambah umur anjing
hewan2.tampilkanInfo(); // Menampilkan info setelah umur bertambah
}
}