package strukturdataprak;

public class PangkatRekursif {
    private int base;
    private int exponent;

    public PangkatRekursif(int base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    // Method rekursif untuk menghitung pangkat
    public long power(int base, int exponent) {
        if (exponent == 0) {
            return 1; // base^0 = 1
        } else {
            return base * power(base, exponent - 1);
        }
    }

    // Method display hasil
    public void display() {
        System.out.println(base + "^" + exponent + " = " + power(base, exponent));
    }

    // Main method untuk uji coba
    public static void main(String[] args) {
        PangkatRekursif p1 = new PangkatRekursif(2, 10);
        PangkatRekursif p2 = new PangkatRekursif(5, 3);

        System.out.println("Hasil perhitungan pangkat (rekursi):");
        p1.display();
        p2.display();
    }
}

