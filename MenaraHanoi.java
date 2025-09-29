package strukturdataprak;
public class MenaraHanoi {
    private int jumlahCakram;

    public MenaraHanoi(int n) {
        this.jumlahCakram = n;
    }

    // Method rekursif untuk menyelesaikan Menara Hanoi
    public void doMenara(int n, char asal, char tujuan, char bantu) {
        if (n == 1) {
            System.out.println("Pindahkan cakram 1 dari " + asal + " ke " + tujuan);
            return;
        }
        doMenara(n - 1, asal, bantu, tujuan);
        System.out.println("Pindahkan cakram " + n + " dari " + asal + " ke " + tujuan);
        doMenara(n - 1, bantu, tujuan, asal);
    }

    // Method display untuk menampilkan hasil
    public void display() {
        System.out.println("Menara Hanoi dengan " + jumlahCakram + " cakram:");
        doMenara(jumlahCakram, 'A', 'C', 'B');
    }

    // Main method untuk uji coba
    public static void main(String[] args) {
        MenaraHanoi hanoi = new MenaraHanoi(3);

        System.out.println("Proses penyelesaian Menara Hanoi (rekursi):");
        hanoi.display();
    }
}
