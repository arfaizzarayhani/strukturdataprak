package strukturdataprak;

public class Mahasiswa {
    String nim;
    String nama;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return nim + " - " + nama;
    }
}