package strukturdataprak;

public class ShellSortArray {
    private int[] arr;
    private int nElemen;

    public ShellSortArray(int max) {
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

    public void ShellSort() {
        int in, out;
        int temp;
        int h = nElemen / 2;
        while (h > 0) {
            for (out = h; out < nElemen; out++) {
                temp = arr[out];
                in = out;
                while (in > h - 1 && arr[in - h] >= temp) {
                    array[in] = arr[in - h];
                    in -= h;
                }
                arr[in] = temp;
                display();
            }
            h /= 2;
        }
    }

    public static void main(String[] args) {
        ShellSortArray arr = new ShellSortArray(8);
        arr.insert(77);
        arr.insert(33);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(66);

        System.out.println("Array sebelum diurutkan:");
        arr.display();

        System.out.println("\nProses pengurutan:");
        arr.ShellSort();

        System.out.println("\nArray setelah diurutkan:");
        arr.display();
    }
}
