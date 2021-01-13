import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache3 {
    private final int capacity;
    private Map<Integer, Integer> cache = new HashMap();

    public Solution146LRUCache3(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
