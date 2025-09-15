package strukturdataprak; 

class Stack { 
    private int maxSize; // Menyimpan ukuran maksimum stack
    private long[] stackArray; // Array untuk menyimpan elemen stack
    private int top; // Menyimpan indeks elemen teratas stack

    public Stack(int size){ // Konstruktor dengan parameter ukuran stack
        maxSize = size; // Set ukuran maksimum
        stackArray = new long[maxSize]; // Inisialisasi array stack
        top = -1; // Stack kosong, top di -1
    }

    public void push(long item){ // Menambahkan elemen ke stack
        stackArray[++top] = item; // Naikkan top, simpan item di posisi top
    }

    public long pop(){ // Mengambil dan menghapus elemen teratas stack
        return stackArray[top--]; // Ambil elemen top, turunkan top
    }

    public long peek(){ // Melihat elemen teratas tanpa menghapus
        return stackArray[top]; // Kembalikan elemen di posisi top
    }

    public boolean isEmpty(){ // Mengecek apakah stack kosong
        return (top == -1); // True jika top -1
    }
    
    public boolean isFull(){ // Mengecek apakah stack penuh
        return (top == maxSize - 1); // True jika top di posisi maksimum
    }
}

public class StackApp { // Kelas utama untuk menjalankan aplikasi
    public static void main(String[] args) { // Fungsi utama
        Stack theStack = new Stack(10); // Membuat stack dengan kapasitas 10
        System.out.println(">> push some items"); // Cetak pesan

        theStack.push(20); // Push angka 20 ke stack
        theStack.push(40); // Push angka 40 ke stack
        theStack.push(60); // Push angka 60 ke stack
        theStack.push(80); // Push angka 80 ke stack

        System.out.println("\n>> pop those items in the stack"); // Cetak pesan

        while (!theStack.isEmpty()){ // Selama stack tidak kosong
            long value = theStack.pop(); // Pop elemen teratas
            System.out.print(value + " "); // Cetak nilai yang di-pop
        }
    }
}
