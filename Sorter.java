package strukturdataprak;
import java.util.*;

// Interface Strategy
interface SortStrategy {
    void sort(List<Integer> data);
    String getName();
}

// Implementasi Bubble Sort
class BubbleSort implements SortStrategy {
    @Override
    public void sort(List<Integer> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) { 
                    Collections.swap(data, j, j + 1);
                }
            }
        }
    }
    @Override
    public String getName() {
        return "Bubble Sort";
    }
}

// Implementasi Quick Sort
class QuickSort implements SortStrategy {
    @Override
    public void sort(List<Integer> data) {
        quickSort(data, 0, data.size() - 1);
    }

    private void quickSort(List<Integer> data, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(data, low, high);
            quickSort(data, low, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, high);
        }
    }

    private int partition(List<Integer> data, int low, int high) {
        int pivot = data.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (data.get(j) <= pivot) {
                i++;
                Collections.swap(data, i, j);
            }
        }
        Collections.swap(data, i + 1, high);
        return i + 1;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }
}

// Kelas utama Sorter
public class Sorter {
    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(List<Integer> data) {
        long startTime = System.nanoTime();

        System.out.println("----------------------------------------");
        System.out.println("Menggunakan Algoritma: " + strategy.getName());
        System.out.println("Data Awal: " + data);
        
        strategy.sort(data);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // ms
        System.out.println("Data Terurut: " + data);
        System.out.println("Waktu Eksekusi: " + duration + " ms");
        System.out.println("----------------------------------------");
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        List<Integer> initialData = new ArrayList<>(Arrays.asList(50, 10, 90, 30, 70, 40));

        // 1. Menggunakan Bubble Sort
        Sorter sorter = new Sorter(new BubbleSort());
        sorter.executeSort(new ArrayList<>(initialData));

        // 2. Ganti strategy menjadi QuickSort
        sorter.setStrategy(new QuickSort());
        sorter.executeSort(new ArrayList<>(initialData));
    }
}
