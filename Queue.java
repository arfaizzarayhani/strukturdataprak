package strukturdataprak;

public class Queue {
    private final int[] queArray;
    private int front;
    private int rear;
    private int nItems;
    private final int maxSize;

    public Queue(int size) {
        maxSize = size;
        queArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int j) {
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }

    public int remove() {
        int temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}
