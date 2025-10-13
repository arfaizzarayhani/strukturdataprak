package strukturdataprak;
public class datanasabah{
    private String noRek;
    private String nama;

    public void datanasabah(String noRek, String nama){
        this.noRek = noRek;
        this.nama = nama;
    }
    public String getNoRek(){
        return noRek;
    }
    public String getNama(){
        return nama;
    }
}