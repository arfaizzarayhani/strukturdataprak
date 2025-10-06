package strukturdataprak;

public class QuickSortMahasiswa {
    private Mahasiswa[] arr;
    private int nElemen;

    public QuickSortMahasiswa(int max) {
        arr = new Mahasiswa[max];
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
    public void quickSortByNama() {
        recQuickSort(0, nElemen - 1);
    }
    private void recQuickSort(int batasKiri, int batasKanan) {
        if (batasKanan - batasKiri <= 0) {
            return;
        } else {
            String pivot = arr[batasKanan].nama;
            int partisi = partitionIt(batasKiri, batasKanan, pivot);
            recQuickSort(batasKiri, partisi - 1);
            recQuickSort(partisi + 1, batasKanan);
        }
    }

    private int partitionIt(int batasKiri, int batasKanan, String pivot) {
        int indexKiri = batasKiri - 1;
        int indexKanan = batasKanan;
        while (true) {
            while (indexKiri < batasKanan && arr[++indexKiri].nama.compareToIgnoreCase(pivot) < 0);
            while (indexKanan > 0 && arr[--indexKanan].nama.compareToIgnoreCase(pivot) > 0);
            if (indexKiri >= indexKanan) {
                break;
            } else {
                swap(indexKiri, indexKanan);
            }
        }
        swap(indexKiri, batasKanan);
        return indexKiri;
    }
    private void swap(int a, int b) {
        Mahasiswa temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        QuickSortMahasiswa data = new QuickSortMahasiswa(6);

        data.insert("234", "Budi");
        data.insert("123", "Ani");
        data.insert("345", "Citra");
        data.insert("567", "Dika");
        data.insert("456", "Eka");
        data.insert("111", "Andi");
        System.out.println("Data sebelum diurutkan:");
        data.display();

        data.quickSortByNama();

        System.out.println("Data setelah diurutkan (Quick Sort berdasarkan Nama):");
        data.display();
    }
}
