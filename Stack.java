package strukturdataprak;

public class Stack {
    private final int[] stackArray;
    private int top;

    public Stack(int size) {
        stackArray = new int[size];
        top = -1;
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
