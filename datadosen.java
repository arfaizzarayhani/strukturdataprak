package strukturdataprak;

public class datadosen {
    private String id;
    private String nama;

    // Constructor yang benar
    public datadosen(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return id + " - " + nama;
    }
}
