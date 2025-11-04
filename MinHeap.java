package strukturdataprak;

public class MinHeap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public MinHeap(int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    // Menyisipkan data pada indeks tertentu (tanpa heapify)
    public void insertAt(int index, int value) {
        heapArray[index] = new Node(value);
    }

    // Menambah ukuran heap
    public void incrementSize() {
        currentSize++;
    }

    // Tampilkan isi heap dan bentuk pohonnya
    public void displayHeap() {
        System.out.println("Heap Array:");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null)
                System.out.print(heapArray[i].getKey() + " ");
            else
                System.out.print("-- ");
        }
        System.out.println();

        // Visualisasi struktur heap
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots + dots);

        while (j < currentSize) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');
            }
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize)
                break;
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' ');
            }
        }
        System.out.println("\n" + dots + dots);
    }

    // Perbaiki heap dari atas ke bawah agar memenuhi sifat MinHeap
    public void trickleDown(int index) {
        int smallerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) { // selama node punya anak
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            // pilih anak terkecil
            if (rightChild < currentSize &&
                heapArray[leftChild].getKey() > heapArray[rightChild].getKey())
                smallerChild = rightChild;
            else
                smallerChild = leftChild;

            if (top.getKey() <= heapArray[smallerChild].getKey())
                break;

            heapArray[index] = heapArray[smallerChild];
            index = smallerChild;
        }
        heapArray[index] = top;
    }

    // HeapSort menggunakan MinHeap — hasil akhir ASCENDING
    public void heapSort() {
        // Bangun MinHeap dari array awal
        for (int i = currentSize / 2 - 1; i >= 0; i--)
            trickleDown(i);

        int tempSize = currentSize;

        // Buat array hasil terurut sementara
        int[] sorted = new int[currentSize];

        // Ekstrak elemen terkecil satu per satu (dari atas heap)
        for (int i = 0; i < tempSize; i++) {
            sorted[i] = heapArray[0].getKey(); // ambil terkecil
            heapArray[0] = heapArray[currentSize - 1]; // ganti root dengan elemen terakhir
            currentSize--;
            trickleDown(0); // perbaiki heap
        }
        // Masukkan kembali hasil yang sudah terurut (buat Node baru!)
        currentSize = tempSize;
        for (int i = 0; i < tempSize; i++) {
            heapArray[i] = new Node(sorted[i]);
        }
    }
}