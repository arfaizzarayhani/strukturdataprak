package strukturdataprak;

public class Queue {
    private final int MAX_SIZE;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        MAX_SIZE = s;
        queArray = new int[MAX_SIZE];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int j) { // Menambahkan item ke belakang (rear)
        if (rear == MAX_SIZE - 1) {
            rear = -1; // Circular queue wrap-around (opsional, disederhanakan)
        }
        queArray[++rear] = j;
        nItems++;
    }

    public int remove() { // Menghapus item dari depan (front)
        int temp = queArray[front++];
        if (front == MAX_SIZE) {
            front = 0; // Circular queue wrap-around
        }
        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}