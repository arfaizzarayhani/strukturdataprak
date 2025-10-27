package strukturdataprak;

public class HashTableQuadraticApp {
    public static void main(String[] args) {
        HashTableQuadratic table = new HashTableQuadratic(15);

        // Menambahkan 10 item
        int[] dataAwal = {656, 715, 658, 777, 837, 599, 899, 15, 420, 898};
        for (int d : dataAwal) {
            table.insert(d);
        }

        System.out.println("=== Sebelum ===");
        table.displayTable();

        // Menambahkan 5 item baru
        int[] dataBaru = {111, 222, 333, 444, 555};
        for (int d : dataBaru) {
            table.insert(d);
        }

        System.out.println("=== Setelah ===");
        table.displayTable();

        // Contoh pencarian
        int keyCari = 777;
        Data hasil = table.find(keyCari);
        if (hasil != null)
            System.out.println("Data " + keyCari + " ditemukan di tabel.");
        else
            System.out.println("Data " + keyCari + " tidak ditemukan.");

        // Contoh penghapusan
        int keyHapus = 658;
        table.delete(keyHapus);
        System.out.println("\nSetelah menghapus " + keyHapus + ":");
        table.displayTable();
    }
}
