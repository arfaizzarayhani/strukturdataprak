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
            System.out.println(arr[i].getNim() + " - " + arr[i].getNama());
        }
        System.out.println();
    }

    public void quickSortByNama() {
        recQuickSort(0, nElemen - 1);
    }

    private void recQuickSort(int batasKiri, int batasKanan) {
        if (batasKanan - batasKiri <= 0) {
        } else {
            String pivot = arr[batasKanan].getNama();
            int partisi = partitionIt(batasKiri, batasKanan, pivot);
            recQuickSort(batasKiri, partisi - 1);
            recQuickSort(partisi + 1, batasKanan);
        }
    }

    @SuppressWarnings("empty-statement")
    private int partitionIt(int batasKiri, int batasKanan, String pivot) {
        int indexKiri = batasKiri - 1;
        int indexKanan = batasKanan;

        while (true) {
            while (indexKiri < batasKanan && arr[++indexKiri].getNama().compareToIgnoreCase(pivot) < 0);
            while (indexKanan > 0 && arr[--indexKanan].getNama().compareToIgnoreCase(pivot) > 0);

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
        QuickSortMahasiswa data = new QuickSortMahasiswa(9);

        data.insert("16650270","Agung");
        data.insert("16650230", "Sofi");
        data.insert("16650280", "Arina");
        data.insert("16650260" ,"Helmi");
        data.insert("16650220", "Ismail");
        data.insert("16650240", "Dinda");
        data.insert("16650250", "Rais");
        data.insert("16650200", "Jundi");
        data.insert("16650210", "Ahmad");

        System.out.println("Data sebelum diurutkan:");
        data.display();

        System.out.println("Proses pengurutan Quick Sort berdasarkan Nama:");
        data.quickSortByNama();

        System.out.println("Data setelah diurutkan:");
        data.display();
    }
}