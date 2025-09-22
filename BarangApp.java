package strukturdataprak;

class Barang {
    int id;
    String nama;
    Barang next;

    public Barang(int id, String nama) {
        this.id = id;
        this.nama = nama;
        this.next = null;
    }
}
class StackBarang {
    private Barang top;

    public StackBarang() {
        top = null;
    }

    public void push(int id, String nama) {
        Barang baru = new Barang(id, nama);
        baru.next = top;
        top = baru;
    }
    public Barang pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return null;
        }
        Barang temp = top;
        top = top.next;
        return temp;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void display() {
        System.out.println("Stack(top-->bottom):");
        Barang current = top;
        while (current != null) {
            System.out.println("{" + current.id + ", " + current.nama + "}");
            current = current.next;
        }
        System.out.println();
    }
}

public class BarangApp {
    public static void main(String[] args) {
        StackBarang stack = new StackBarang();

        stack.push(1, "VCD");
        stack.push(2, "TV");
        stack.display();

        stack.push(3, "kulkas");
        stack.push(4, "PC");
        stack.push(5, "rice cooker");
        stack.push(6, "dispenser");
        stack.display();

        stack.pop();
        stack.pop();
        stack.display();
    }
}