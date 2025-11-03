package strukturdataprak;

public class HeapSortApp {
    public static void main(String[] args) {
        int size = 10;
        Heap heap = new Heap(size);

        // Memasukkan data random ke heap
        int[] data = {45, 12, 35, 2, 50, 25, 7, 60, 15, 5};
        System.out.println("Array sebelum diurutkan:");
        for (int i = 0; i < size; i++) {
            heap.insertAt(i, data[i]);
            heap.incrementSize();
            System.out.print(data[i] + " ");
        }

        // Menampilkan array awal
        System.out.println("\n\nArray sebelum proses HeapSort:");
        heap.displayArray();

        // Menjalankan heapsort
        heap.heapSort();

        // Menampilkan hasil
        System.out.println("\nArray setelah diurutkan:");
        heap.displayArray();
    }
}