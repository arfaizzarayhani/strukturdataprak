package strukturdataprak;

class Data {
    private int key;

    public Data(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}

public class HashTableQuadratic {
    private Data[] hashArray;
    private int size;

    public HashTableQuadratic(int size) {
        this.size = size;
        hashArray = new Data[size];
    }

    public void displayTable() {
        System.out.println("\nIsi Hash Table:");
        for (int i = 0; i < size; i++) {
            if (hashArray[i] != null)
                System.out.println("Index " + i + " : " + hashArray[i].getKey());
            else
                System.out.println("Index " + i + " : --");
        }
    }

    // fungsi hash dasar
    public int hashFunc(int key) {
        int h = key % size;
        if (h < 0) h += size; // pastikan selalu positif
        return h;
    }

    public void insert(int key) {
        Data item = new Data(key);
        int baseHash = hashFunc(key);
        int hashVal = baseHash;
        int i = 1;
        
        // quadratic probing
        while (hashArray[hashVal] != null) {
            hashVal = (baseHash + i * i) % size;
            if (hashVal < 0) hashVal = (hashVal + size) % size; // anti-negatif
            i++;
            if (i > size) {
                System.out.println("Tabel penuh, tidak dapat menyimpan: " + key);
                return;
            }
        }
        hashArray[hashVal] = item;
    }

    public Data find(int key) {
        int baseHash = hashFunc(key);
        int hashVal = baseHash;
        int i = 1;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];

            hashVal = (baseHash + i * i) % size;
            if (hashVal < 0) hashVal = (hashVal + size) % size;
            i++;
            if (i > size) break;
        }
        return null;
    }

    public Data delete(int key) {
        int baseHash = hashFunc(key);
        int hashVal = baseHash;
        int i = 1;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Data temp = hashArray[hashVal];
                hashArray[hashVal] = null;
                return temp;
            }

            hashVal = (baseHash + i * i) % size;
            if (hashVal < 0) hashVal = (hashVal + size) % size;
            i++;
            if (i > size) break;
        }
        return null;
    }
}