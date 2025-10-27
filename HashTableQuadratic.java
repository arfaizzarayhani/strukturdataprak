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
        System.out.println();
    }

    public int hashFunc(int key) {
        return key % size;
    }

    public void insert(int key) {
        Data item = new Data(key);
        int hashVal = hashFunc(key);
        int i = 1;

        // quadratic probing: f(i) = i²
        while (hashArray[hashVal] != null) {
            hashVal = (hashFunc(key) + i * i) % size;
            i++;
        }
        hashArray[hashVal] = item;
    }

    public Data find(int key) {
        int hashVal = hashFunc(key);
        int i = 1;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            hashVal = (hashFunc(key) + i * i) % size;
            i++;
        }
        return null;
    }

    public Data delete(int key) {
        int hashVal = hashFunc(key);
        int i = 1;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Data temp = hashArray[hashVal];
                hashArray[hashVal] = null;
                return temp;
            }
            hashVal = (hashFunc(key) + i * i) % size;
            i++;
        }
        return null;
    }
}