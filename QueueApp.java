package strukturdataprak;

class Mahasiswa {
    int nim;
    String nama;
    Mahasiswa next;

    public Mahasiswa(int nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.next = null;
    }
}

class QueueMahasiswa {
    private Mahasiswa front;
    private Mahasiswa rear;

    public QueueMahasiswa() {
        front = rear = null;
    }

    public void insert(int nim, String nama) {
        Mahasiswa baru = new Mahasiswa(nim, nama);
        if (isEmpty()) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
    }

    public Mahasiswa remove() { // dequeue
        if (isEmpty()) return null;
        Mahasiswa temp = front;
        front = front.next;
        if (front == null) rear = null;
        return temp;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        System.out.println("Queue (front-->rear):");
        Mahasiswa cur = front;
        while (cur != null) {
            System.out.println(cur.nim + " " + cur.nama);
            cur = cur.next;
        }
        System.out.println();
    }
}

public class QueueApp {
    public static void main(String[] args) {
        QueueMahasiswa q = new QueueMahasiswa();

        // initial inserts
        q.insert(1665100, "Dee");
        q.insert(1665200, "Deaja");
        q.display();

        q.insert(1665300, "Ami");
        q.insert(1665400, "Haya");
        q.insert(1665500, "Yati");
        q.display();

        q.remove();
        q.remove();
        q.display();
    }
}