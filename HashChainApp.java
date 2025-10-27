package strukturdataprak;
public class HashChainApp {
    public static void main(String[] args) {
        HashTable2 table = new HashTable2(15);
        // Menambahkan 10 data
        int[] dataAwal = {21, 35, 14, 88, 42, 55, 67, 92, 73, 10};
        for (int d : dataAwal) {
            table.insert(d);
        }
        System.out.println("Tabel setelah penambahan data:");
        table.displayTable();
    }
}