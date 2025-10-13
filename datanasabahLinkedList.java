package strukturdataprak;

// Node tunggal dalam LinkedList
class Nasabah {
    public String noRek;
    public String nama;
    public Nasabah next;

    public Nasabah(String noRek, String nama) {
        this.noRek = noRek;
        this.nama = nama;
    }

    public void displayNasabah() {
        System.out.print("[No Rek: " + noRek + ", Nama: " + nama + "] ");
    }
}

// LinkedList yang menyimpan data nasabah
class LinkedListNasabah {
    private Nasabah first;

    public LinkedListNasabah() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    // Tambah data di depan list
    public void insertFirst(String noRek, String nama) {
        Nasabah newNasabah = new Nasabah(noRek, nama);
        newNasabah.next = first;
        first = newNasabah;
    }

    // Hapus data pertama
    public Nasabah deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Nasabah temp = first;
        first = first.next;
        return temp;
    }

    // Linear Search berdasarkan noRek
    public Nasabah find(String noRek) {
        Nasabah current = first;
        while (current != null && !current.noRek.equals(noRek)) {
            current = current.next;
        }
        return current; // bisa null kalau tidak ditemukan
    }

    // Hapus data berdasarkan noRek
    public Nasabah delete(String noRek) {
        Nasabah current = first;
        Nasabah previous = first;

        while (current != null && !current.noRek.equals(noRek)) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    // Menampilkan seluruh isi LinkedList
    public void displayList() {
        System.out.println("List Nasabah (first --> last): ");
        Nasabah current = first;
        while (current != null) {
            current.displayNasabah();
            current = current.next;
        }
        System.out.println();
    }
}

// Program utama
public class datanasabahLinkedList {
    public static void main(String[] args) {
        LinkedListNasabah daftar = new LinkedListNasabah();

        // Tambah data
        daftar.insertFirst("1004", "Dewi");
        daftar.insertFirst("1003", "Citra");
        daftar.insertFirst("1002", "Budi");
        daftar.insertFirst("1001", "Andi");

        daftar.displayList();

        // Cari data (linear search)
        String cari = "1003";
        Nasabah hasil = daftar.find(cari);
        if (hasil != null) {
            System.out.println("Data ditemukan: No Rek " + hasil.noRek + ", Nama " + hasil.nama);
        } else {
            System.out.println("Data dengan no rekening " + cari + " tidak ditemukan");
        }

        // Hapus data
        daftar.delete("1002");
        System.out.println("\nSetelah menghapus no rek 1002:");
        daftar.displayList();
    }
}