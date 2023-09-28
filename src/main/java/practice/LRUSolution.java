package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUSolution {
    private final int sizeLimit;
    private Map<Integer, Integer> cache = new HashMap();
    private List<Integer> queue = new LinkedList<>();

    public LRUSolution(int sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    public void put(int key, int value) {
        if (this.queue.size() >= sizeLimit) {
            this.cache.remove(this.queue.remove(0));
        }
        this.queue.add(key);
        this.cache.put(key, value);
    }

    public int get(int key) {
        return this.cache.getOrDefault(key, -1);
    }
}
