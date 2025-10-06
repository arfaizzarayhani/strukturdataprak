package strukturdataprak;

public class MergeSortMahasiswa {
    private Mahasiswa[] arr;
    private int nElemen;

    public MergeSortMahasiswa(int size) {
        arr = new Mahasiswa[size];
        nElemen = 0;
    }
    public void insert(String nim, String nama) {
        arr[nElemen] = new Mahasiswa(nim, nama);
        nElemen++;
    }
    public void display() {
        for (int i = 0; i < nElemen; i++) {
            System.out.println(arr[i].nim + " - " + arr[i].nama);
        }
        System.out.println();
    }
    public void mergeSortByNama() {
        Mahasiswa[] workSpace = new Mahasiswa[nElemen];
        recMergeSort(workSpace, 0, nElemen - 1);
    }
    private void recMergeSort(Mahasiswa[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }
    private void merge(Mahasiswa[] workSpace, int lowIndex, int highIndex, int upperBound) {
        int j = 0;
        int lowerBound = lowIndex;
        int mid = highIndex - 1;
        int n = upperBound - lowerBound + 1;

        while (lowIndex <= mid && highIndex <= upperBound) {
            if (arr[lowIndex].nama.compareToIgnoreCase(arr[highIndex].nama) < 0) {
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
        MergeSortMahasiswa data = new MergeSortMahasiswa(6);

        data.insert("234", "Budi");
        data.insert("123", "Ani");
        data.insert("345", "Citra");
        data.insert("567", "Dika");
        data.insert("456", "Eka");
        data.insert("111", "Andi");

        System.out.println("Data sebelum diurutkan:");
        data.display();

        data.mergeSortByNama();

        System.out.println("Data setelah diurutkan (Merge Sort berdasarkan Nama):");
        data.display();
    }
}