package strukturdataprak;

class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char c) {
        if (isFull()) {
            System.out.println("Stack penuh! Tidak bisa menambah elemen.");
            return;
        }
        stackArray[++top] = c;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada elemen untuk di-pop.");
            return '\0'; // karakter null sebagai tanda kosong
        }
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
