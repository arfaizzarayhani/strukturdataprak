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
        System.out.println("Heap Array:");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null)
                System.out.print(heapArray[i].getKey() + " ");
            else
                System.out.print("-- ");
        }
        System.out.println();

        // Visualisasi bentuk heap
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots + dots);

        while (j < currentSize) {
            if (column == 0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');

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
        while (index < currentSize / 2) { // selama masih punya anak
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            // pilih anak yang lebih besar
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

        for (int i = currentSize / 2 - 1; i >= 0; i--)
            trickleDown(i);

        int tempSize = currentSize;

        Node[] sorted = new Node[tempSize];
        for (int i = tempSize - 1; i >= 0; i--) {
            Node largest = heapArray[0];
            heapArray[0] = heapArray[currentSize - 1];
            currentSize--;
            trickleDown(0);
            sorted[i] = largest; // simpan dari belakang → ascending
        }
        currentSize = tempSize;
        for (int i = 0; i < tempSize; i++) {
            heapArray[i] = sorted[tempSize - 1 - i];
        }
    }
}
