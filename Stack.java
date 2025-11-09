package strukturdataprak;

public class Stack {
    private final int MAX_SIZE;
    private int[] stackArray;
    private int top;

    public Stack(int size) { // Constructor yang diperlukan
        MAX_SIZE = size;
        stackArray = new int[MAX_SIZE];
        top = -1; // Stack kosong
    }
    public void push(int j) {
        stackArray[++top] = j;
    }
    public int pop() {
        return stackArray[top--];
    }
    public int peek() {
        return stackArray[top]; 
    }
    public boolean isEmpty() {
        return (top == -1);
    }
}