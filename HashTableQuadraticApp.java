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
        int[] dataBaru = {111, 222, 333, 16, 89};
        for (int d : dataBaru) {
            table.insert(d);
        }

        System.out.println("=== Setelah ===");
        table.displayTable();

    }
}
