package strukturdataprak;
public class datakontakApp {

    public static void main(String[] args) {
        datakontak[] daftarKontak = new datakontak[10];
        int jumlahKontak = 0;

        daftarKontak[jumlahKontak++] = new datakontak("081234567890", "Andi");
        daftarKontak[jumlahKontak++] = new datakontak("082233445566", "Budi");
        daftarKontak[jumlahKontak++] = new datakontak("083344556677", "Cici");

        System.out.println("=== DATA KONTAK AWAL ===");
        tampilkan(daftarKontak, jumlahKontak);

        jumlahKontak = hapusKontak(daftarKontak, jumlahKontak, "Budi");

        System.out.println("\n=== SETELAH HAPUS 'Budi' ===");
        tampilkan(daftarKontak, jumlahKontak);

        urutkan(daftarKontak, jumlahKontak);

        System.out.println("\n=== SETELAH DIURUTKAN BERDASARKAN NAMA ===");
        tampilkan(daftarKontak, jumlahKontak);
    }

    public static void tampilkan(datakontak[] daftar, int n) {
        if (n == 0) {
            System.out.println("Tidak ada data kontak.");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println((i + 1) + ". " + daftar[i]);
            }
        }
    }

    public static int hapusKontak(datakontak[] daftar, int n, String nama) {
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Kontak dengan nama " + nama + " tidak ditemukan.");
            return n;
        }

        for (int i = index; i < n - 1; i++) {
            daftar[i] = daftar[i + 1];
        }
        daftar[n - 1] = null;

        System.out.println("Kontak '" + nama + "' berhasil dihapus.");
        return n - 1;
    }
    public static void urutkan(datakontak[] daftar, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (daftar[j].getNama().compareToIgnoreCase(daftar[j + 1].getNama()) > 0) {
                    datakontak temp = daftar[j];
                    daftar[j] = daftar[j + 1];
                    daftar[j + 1] = temp;
                }
            }
        }
    }
}