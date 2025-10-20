package strukturdataprak;
public class datanasabahApp{
    private datanasabah[] arr;
    private int nElemen;

    public datanasabahApp(int max){
        arr = new datanasabah[max];
        nElemen = 0;
    }
    public void insert(String noRek, String nama){
        arr[nElemen] = new datanasabah();
        arr[nElemen].datanasabah(noRek, nama);
        nElemen++;
    }
    public void displayArray(){
        for(int i=0; i<nElemen; i++){
            System.out.println("No Rek: " + arr[i].getNoRek() + ", Nama: " + arr[i].getNama());
        }
        System.out.println();
    }
    public void BubbleSortbyNoRek(){
        int batas, i;
        for (batas = nElemen - 1; batas > 0; batas--){
            for(i=0; i<batas; i++){
                if(arr[i].getNoRek().compareTo(arr[i+1].getNoRek())>0){
                    swap(i, i+1);
                }
            }
        }
    }
    public void SelectionSortbyNoRek(){
        int awal, i, min;
        for (awal = 0; awal < nElemen - 1; awal++){
            min = awal;
            for(i=awal + 1; i<nElemen; i++){
                if(arr[i].getNoRek().compareTo(arr[min].getNoRek())<0){
                    min = i;
                }
            }
            swap(awal, min);
        }
    }
    public void InsertionbyName(){
        for(int i=1; i<nElemen; i++){
            datanasabah temp = arr[i];
            int j = i;
            while(j>0 && arr[j-1].getNama().compareTo(temp.getNama())>0){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    private void swap(int one, int two){
        datanasabah temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
    public void BubbleSortbyNama(){
        int batas, i;
        for (batas = nElemen - 1; batas > 0; batas--){
            for(i=0; i<batas; i++){
                if(arr[i].getNama().compareTo(arr[i+1].getNama())>0){
                    swap(i, i+1);
                }
            }
        }
    }
    public void SelectionSortbyNama(){
        int awal, i, min;
        for (awal = 0; awal < nElemen - 1; awal++){
            min = awal;
            for(i=awal + 1; i<nElemen; i++){
                if(arr[i].getNama().compareTo(arr[min].getNama())<0){
                    min = i;
                }
            }
            swap(awal, min);
        }
    }
    public void InsertionSortbyNama(){
        for(int i=1; i<nElemen; i++){
            datanasabah temp = arr[i];
            int j = i;
            while(j>0 && arr[j-1].getNama().compareTo(temp.getNama())>0){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    public void InsertionSortbyNoRek(){
        for(int i=1; i<nElemen; i++){
            datanasabah temp = arr[i];
            int j = i;
            while(j>0 && arr[j-1].getNoRek().compareTo(temp.getNoRek())>0){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    
}