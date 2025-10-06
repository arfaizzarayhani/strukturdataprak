package strukturdataprak;

public class ShellSortMahasiswa {
    private Mahasiswa[] arr;
    private int nElemen;

    public ShellSortMahasiswa(int max) {
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
    public void shellSortByNim() {
        int in, out;
        Mahasiswa temp;
        int h = nElemen / 2;

        while (h > 0) {
            for (out = h; out < nElemen; out++) {
                temp = arr[out];
                in = out;

                while (in > h - 1 && arr[in - h].nim.compareTo(temp.nim) > 0) {
                    arr[in] = arr[in - h];
                    in -= h;
                }

                arr[in] = temp;
            }
            h /= 2;
        }
    }
    public static void main(String[] args) {
        ShellSortMahasiswa data = new ShellSortMahasiswa(6);

        data.insert("234", "Budi");
        data.insert("123", "Ani");
        data.insert("345", "Citra");
        data.insert("567", "Dika");
        data.insert("456", "Eka");
        data.insert("111", "Andi");

        System.out.println("Data sebelum diurutkan:");
        data.display();

        System.out.println("Proses pengurutan Shell Sort berdasarkan NIM:");
        data.shellSortByNim();

        System.out.println("Data setelah diurutkan:");
        data.display();
    }
}
