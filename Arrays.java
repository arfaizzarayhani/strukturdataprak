package strukturdataprak;

public class Arrays {
    private int[] arr;
    private int nElemen;

    public Arrays(int size) {
        arr = new int[size];
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
    public void mergeSort() {
        int[] workSpace = new int[nElemen];
        recMergeSort(workSpace, 0, nElemen - 1);
    }
    private void recMergeSort(int[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }
    private void merge(int[] workSpace, int lowIndex, int highIndex, int upperBound) {
        int j = 0;
        int lowerBound = lowIndex;
        int mid = highIndex - 1;
        int n = upperBound - lowerBound + 1;

        while (lowIndex <= mid && highIndex <= upperBound) {
            if (arr[lowIndex] < arr[highIndex]) {
                workSpace[j++] = arr[lowIndex++];
            } else {
                workSpace[j++] = arr[highIndex++];
            }
        }

        while (lowIndex <= mid) {
            workSpace[j++] = arr[lowIndex++];
        }
        while (highIndex <= upperBound) {
            workSpace[j++] = arr[highIndex++];
        }
        for (j = 0; j < n; j++) {
            arr[lowerBound + j] = workSpace[j];
        }
    }
    public static void main(String[] args) {
        Arrays data = new Arrays(10);

        // Tambahkan 10 item tidak berurutan
        data.insert(34);
        data.insert(7);
        data.insert(23);
        data.insert(32);
        data.insert(5);
        data.insert(62);
        data.insert(15);
        data.insert(42);
        data.insert(13);
        data.insert(8);

        // Tampilkan sebelum diurutkan
        System.out.println("Data sebelum diurutkan:");
        data.display();

        // Lakukan merge sort
        data.mergeSort();

        // Tampilkan setelah diurutkan
        System.out.println("Data setelah diurutkan (merge sort):");
        data.display();
    }
}