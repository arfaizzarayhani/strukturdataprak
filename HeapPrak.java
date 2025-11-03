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

    public void displayArray() {
        for (int i = 0; i < maxSize; i++) {
            if (heapArray[i] != null)
                System.out.print(heapArray[i].getKey() + " ");
            else
                System.out.print("-- ");
        }
        System.out.println();
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
        // Bangun heap
        for (int i = currentSize / 2 - 1; i >= 0; i--)
            trickleDown(i);

        // Hapus elemen dari heap
        for (int i = currentSize - 1; i >= 0; i--) {
            Node biggest = heapArray[0];
            heapArray[0] = heapArray[i];
            heapArray[i] = biggest;
            currentSize--;
            trickleDown(0);
        }
    }
}
