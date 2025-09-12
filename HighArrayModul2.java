package strukturdataprak;

public class HighArrayModul2 {
    private int[] arr;
    private int nElemen;

    public HighArrayModul2(int max) {
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

    public void BubbleSort() {
        int batas, i;
        for (batas = nElemen - 1; batas > 0; batas--) {
            for (i = 0; i < batas; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(i, i + 1);
                    display(); // tampilkan array setelah pertukaran
                }
            }
        }
    }

    private void swap(int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public static void main(String[] args) {
        HighArrayModul2 arr = new HighArrayModul2(10);

        arr.insert(64);
        arr.insert(34);
        arr.insert(25);
        arr.insert(12);
        arr.insert(22);
        arr.insert(11);

        System.out.println("Sebelum sorting:");
        arr.display();

        System.out.println("\nProses Bubble Sort:");
        arr.BubbleSort();

        System.out.println("\nSesudah sorting:");
        arr.display();
    }
}
