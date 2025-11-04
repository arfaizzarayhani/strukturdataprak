package strukturdataprak;

public class HeapPrak {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public HeapPrak(int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    public void insertAt(int index, int value) {
        heapArray[index] = new Node(value);
    }

    public void incrementSize() {
        currentSize++;
    }

    public void displayHeap() {
        System.out.println("Heap Array: ");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getKey() + " ");
            } else {
                System.out.print("-- ");
            }
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

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize &&
                heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
                largerChild = rightChild;
            else
                largerChild = leftChild;

            if (top.getKey() >= heapArray[largerChild].getKey())
                break;

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public void heapSort() {
        // Bangun heap (heapify)
        for (int i = currentSize / 2 - 1; i >= 0; i--)
            trickleDown(i);

        // Ekstraksi elemen terbesar satu per satu
        int tempSize = currentSize;
        for (int i = currentSize - 1; i >= 0; i--) {
            Node biggest = heapArray[0];
            heapArray[0] = heapArray[i];
            heapArray[i] = biggest;
            currentSize--;
            trickleDown(0);
        }
        currentSize = tempSize; // kembalikan ukuran agar displayHeap bisa menampilkan semua elemen
    }
}