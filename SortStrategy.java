package strukturdataprak;

import java.util.List;

public interface SortStrategy {
    void sort(List<Integer> data);
    String getName();
}