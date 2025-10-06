package strukturdataprak;

public class QuickSortArray {
    private int[] arr;
    private int nElemen;

    public QuickSortArray(int max) {
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
    public void quickSort() {
        recQuickSort(0, nElemen - 1);
    }
    public void recQuickSort(int batasKiri, int batasKanan) {
        if (batasKanan - batasKiri <= 0) {
            return; // basis rekursi
        } else {
            int pivot = arr[batasKanan]; // pilih pivot elemen paling kanan
            int partisi = partitionIt(batasKiri, batasKanan, pivot);
            recQuickSort(batasKiri, partisi - 1); // sort kiri
            recQuickSort(partisi + 1, batasKanan); // sort kanan
        }
    }
    public int partitionIt(int batasKiri, int batasKanan, int pivot) {
        int indexKiri = batasKiri - 1;
        int indexKanan = batasKanan;
        while (true) {
            while (indexKiri < batasKanan && arr[++indexKiri] < pivot); 
            while (indexKanan > 0 && arr[--indexKanan] > pivot);
            if (indexKiri >= indexKanan) {
                break;
            } else {
                swap(indexKiri, indexKanan);
            }
        }
        swap(indexKiri, batasKanan); // letakkan pivot di posisi benar
        return indexKiri;
    }
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        QuickSortArray arr = new QuickSortArray(8);
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

        arr.quickSort();

        System.out.println("\nArray setelah diurutkan:");
        arr.display();
    }
}
