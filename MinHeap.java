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
        int smallerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

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
    public void heapSort() {
        // Bangun min-heap
        for (int i = currentSize / 2 - 1; i >= 0; i--)
            trickleDown(i);

        // Proses pengurutan
        for (int i = currentSize - 1; i >= 0; i--) {
            Node smallest = heapArray[0];
            heapArray[0] = heapArray[i];
            heapArray[i] = smallest;
            currentSize--;
            trickleDown(0);
        }
    }
}