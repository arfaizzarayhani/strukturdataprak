package strukturdataprak;

public class HighArrayInsertionTrace {
    private int[] arr;
    private int nElemen;

    public HighArrayInsertionTrace(int max) {
        arr = new int[max];
        nElemen = 0;
    }

    public void insert(int value) {
        arr[nElemen] = value;
        nElemen++;
    }

    public void display() {
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void InsertionSortTrace() {
        int i, curIn;
        for (curIn = 1; curIn < nElemen; curIn++) {
            int temp = arr[curIn];
            i = curIn;

            while (i > 0 && arr[i - 1] > temp) {
                arr[i] = arr[i - 1];
                display(); 
                i--;
            }
            arr[i] = temp;
            display(); 
        }
    }

    public static void main(String[] args) {
        HighArrayInsertionTrace arr = new HighArrayInsertionTrace(10);
        arr.insert(64);
        arr.insert(34);
        arr.insert(25);
        arr.insert(12);
        arr.insert(22);
        arr.insert(11);

        System.out.println("Sebelum sorting:");
        arr.display();

        System.out.println("\nProses Insertion Sort:");
        arr.InsertionSortTrace();

        System.out.println("\nSesudah sorting:");
        arr.display();
    }
}
