package strukturdataprak;

public class datadosenApp {
    private datadosen[] arr;
    private int nElemen;

    public datadosenApp(int max) {
        arr = new datadosen[max];
        nElemen = 0;
    }

    public void insert(String id, String nama) {
        arr[nElemen] = new datadosen(id, nama);
        nElemen++;
    }

    public void display() {
        for (int i = 0; i < nElemen; i++) {
            System.out.println(arr[i]);
        }
    }

    public boolean update(String id, String namaBaru) {
        for (int i = 0; i < nElemen; i++) {
            if (arr[i].getId().equalsIgnoreCase(id)) {
                arr[i].setNama(namaBaru);
                return true;
            }
        }
        return false;
    }

    public void InsertionbyName() {
        for (int i = 1; i < nElemen; i++) {
            datadosen temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1].getNama().compareTo(temp.getNama()) > 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public void InsertionbyId() {
        for (int i = 1; i < nElemen; i++) {
            datadosen temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1].getId().compareTo(temp.getId()) > 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        datadosenApp ds = new datadosenApp(10);
        ds.insert("197810", "Anna");
        ds.insert("198209", "Charles");
        ds.insert("196409", "Bobby");

        System.out.println("Data Dosen sebelum diurutkan:");
        ds.display();

        ds.InsertionbyName();
        System.out.println("\nData Dosen setelah diurutkan berdasarkan nama:");
        ds.display();

        ds.InsertionbyId();
        System.out.println("\nData Dosen setelah diurutkan berdasarkan ID:");
        ds.display();

        boolean updated = ds.update("197810", "Alicia");
        if (updated) {
            System.out.println("\nData Dosen setelah update:");
            ds.display();
        } else {
            System.out.println("\nDosen dengan ID tersebut tidak ditemukan.");
        }
    }
}
