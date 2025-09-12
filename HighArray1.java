package strukturdataprak;

public class HighArray1 {

    private int[] arr;
    private int nElemen;

    public HighArray1(int max) {
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
                display(); // tampilkan setelah pergeseran
                i--;
            }
            arr[i] = temp;
            display(); // tampilkan setelah penyisipan
        }
    }

    private void swap(int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public static void main(String[] args) {
        HighArray arr = new HighArray(10);

        // Insert 6 item ke array
        arr.insert(64);
        arr.insert(34);
        arr.insert(25);
        arr.insert(12);
        arr.insert(22);
        arr.insert(11);

        System.out.println("Sebelum sorting:");
        arr.display();

        arr.BubbleSort();

        System.out.println("Sesudah sorting:");
        arr.display();
    }
}
