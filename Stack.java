package strukturdataprak;

public class Stack {
    private int maxSize;
    private Node[] stackArray;
    private int top;

    public Stack(int s) {
        maxSize = s;
        stackArray = new Node[maxSize];
        top = -1;
    }

    public void push(Node j) {
        stackArray[++top] = j;
    }

    public Node pop() {
        return stackArray[top--];
    }

    public Node peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
