package strukturdataprak;

public class datakontak {
    private String noTelp;
    private String nama;

    public datakontak(String noTelp, String nama) {
        this.noTelp = noTelp;
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return noTelp + " - " + nama;
    }
}
