package strukturdataprak; 

class Queue { 
    private int maxSize; // Menyimpan ukuran maksimum queue
    private long[] queueArray; // Array untuk menyimpan elemen queue
    private int front; // Indeks elemen paling depan
    private int rear; // Indeks elemen paling belakang
    private int nItems; // Jumlah elemen dalam queue

    public Queue(int size) { // Konstruktor dengan parameter ukuran queue
        this.maxSize = size; // Set ukuran maksimum
        this.queueArray = new long[maxSize]; // Inisialisasi array queue
        this.front = 0; // Awal front di indeks 0
        this.rear = -1; // Awal rear di -1 (belum ada elemen)
        this.nItems = 0; // Awal jumlah elemen 0
    }

    public void insert(long value) { // Menambahkan elemen ke belakang queue
        if (rear == maxSize - 1) { // Jika rear di ujung array
            rear = -1; // Kembali ke awal (circular queue)
        }
        queueArray[++rear] = value; // Naikkan rear, simpan value di posisi rear
        nItems++; // Tambah jumlah elemen
    }

    public long remove() { // Mengambil dan menghapus elemen paling depan
       long temp = queueArray[front++]; // Ambil elemen front, naikkan front
       if (front == maxSize) { // Jika front di ujung array
           front = 0; // Kembali ke awal (circular queue)
       }
        nItems--; // Kurangi jumlah elemen
       return temp; // Kembalikan nilai yang dihapus
    }

    public long peekFront() { // Melihat elemen paling depan tanpa menghapus
       return queueArray[front]; // Kembalikan nilai di posisi front
    }

    public boolean isEmpty() { // Mengecek apakah queue kosong
        return nItems == 0; // True jika jumlah elemen 0
    }

    public boolean isFull() { // Mengecek apakah queue penuh
        return nItems == maxSize; // True jika jumlah elemen sama dengan kapasitas
    }

    public int size() { // Mengembalikan jumlah elemen dalam queue
        return nItems; // Kembalikan jumlah elemen
    }
}

public class QueueApp { // Kelas utama untuk menjalankan aplikasi
    public static void main(String[] args) { // Fungsi utama
        Queue theQueue = new Queue(5); // Membuat queue berkapasitas 5

        theQueue.insert(10); // Masukkan 10 ke queue
        theQueue.insert(20); // Masukkan 20 ke queue
        theQueue.insert(30); // Masukkan 30 ke queue
        theQueue.insert(40); // Masukkan 40 ke queue
        theQueue.remove(); // Hapus elemen paling depan (10)
        theQueue.remove(); // Hapus elemen paling depan (20)
        theQueue.remove(); // Hapus elemen paling depan (30)
        theQueue.insert(50); // Masukkan 50 ke queue
        theQueue.insert(60); // Masukkan 60 ke queue
        theQueue.insert(70); // Masukkan 70 ke queue
        theQueue.insert(80); // Masukkan 80 ke queue

        while (!theQueue.isEmpty()) { // Selama queue tidak kosong
            long n = theQueue.remove(); // Hapus elemen paling depan
            System.out.print(n + " "); // Cetak nilai yang dihapus
        }
        System.out.println(""); // Cetak baris baru
    }
}
