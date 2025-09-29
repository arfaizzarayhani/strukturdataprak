package strukturdataprak;
public class Segitiga {

    // method rekursif untuk menghitung bilangan segitiga
    public int triangleRecur(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangleRecur(n - 1);
        }
    }

    // method untuk mencetak piramida angka
    public void printPiramida(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println(); // pindah baris
        }
    }

    // method main
    public static void main(String[] args) {
        Segitiga obj = new Segitiga();
        int n = 5;
        int hasil = obj.triangleRecur(n);

        System.out.println("Bilangan segitiga dari " + n + " adalah: " + hasil);
        System.out.println("Piramida angka dengan n = " + n + ":");
        obj.printPiramida(n);
    }
}
