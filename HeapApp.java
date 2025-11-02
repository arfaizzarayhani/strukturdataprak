package strukturdataprak;

public class HeapApp {
    public static void main(String[] args) {
        // Deklarasi heap dengan ukuran 35
        Heap heap = new Heap(35);
        
        // Menambahkan 12 item ke heap
        int[] data = {70, 40, 50, 20, 60, 100, 80, 30, 10, 90, 110, 120};
        System.out.println("Menambahkan elemen ke heap:");
        for (int i = 0; i < data.length; i++) {
            heap.insert(data[i]);
            System.out.print(data[i] + " ");
        }

        // Menampilkan heap setelah 12 insert
        System.out.println("\n\nIsi heap setelah 12 insert:");
        heap.displayHeap();

        // Tambah Item baru
        System.out.println("\nMenambahkan item baru 130 ke heap...");
        heap.insert(130);

        System.out.println("\nHeap setelah penambahan item baru:");
        heap.displayHeap();

        // Hapus Item Heap
        System.out.println("\nMenghapus root node (nilai maksimum pada MAX HEAP)...");
        heap.remove();

        System.out.println("\nHeap setelah penghapusan root:");
        heap.displayHeap();
    }
}