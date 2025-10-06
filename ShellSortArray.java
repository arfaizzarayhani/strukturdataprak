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
    // Menentukan nilai awal gap (h) dengan rumus Knuth: h = 3*h + 1
    // Urutan h: 1, 4, 13, 40, ... sampai mendekati nElemen/3
    int h = 1;
    while (h <= nElemen / 3) {
        h = 3 * h + 1;   // cari gap terbesar sesuai Knuth
    }
    // Proses sorting dengan interval h
    while (h > 0) {
        // Lakukan Insertion Sort dengan jarak h
        for (out = h; out < nElemen; out++) {
            temp = arr[out];
            in = out;
            // Geser elemen yang lebih besar sejauh h
            while (in > h - 1 && arr[in - h] >= temp) {
                arr[in] = arr[in - h];
                in -= h;
            }
            // Tempatkan nilai pada posisi yang sesuai
            arr[in] = temp;
            // Menampilkan array setiap kali elemen dipindahkan
            display();
        }
        // Kurangi gap dengan rumus Knuth: h = (h - 1) / 3
        h = (h - 1) / 3;
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
