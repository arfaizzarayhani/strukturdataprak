package strukturdataprak;

public class HashTableApp {
    public static void main(String[] args) {
        HashTables table = new HashTables(15);

        // 10 data awal
        int[] dataAwal = {21, 35, 14, 88, 42, 55, 67, 92, 73, 10};

        System.out.println("=== Menambahkan 10 item pertama ===");
        for (int d : dataAwal) {
            table.insert(d);
        }

        System.out.println("\nIsi tabel setelah 10 data pertama:");
        table.displayTable();

        // Tambahkan 5 item baru
        int[] dataBaru = {28, 49, 101, 37, 90};

        System.out.println("\n=== Menambahkan 5 item baru ===");
        for (int d : dataBaru) {
            table.insert(d);
        }
        System.out.println("\nIsi tabel setelah 15 data (setelah penambahan):");
        table.displayTable();

        int cariKey = 67;
        System.out.println("Mencari data dengan key = " + cariKey);
        Data hasil = table.find(cariKey);

        if (hasil != null) {
            System.out.println("Data ditemukan pada hash table: " + hasil.getKey());
        } else {
            System.out.println("Data dengan key " + cariKey + " tidak ditemukan.");
        }
        int hapusKey = 42;
        System.out.println("Menghapus data dengan key = " + hapusKey);

        Data hasilHapus = table.delete(hapusKey);
        if (hasilHapus != null) {
            System.out.println("Data dengan key " + hapusKey + " berhasil dihapus.");
        } else {
            System.out.println("Data dengan key " + hapusKey + " tidak ditemukan.");
        }
    }
}
