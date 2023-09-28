package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUSolution {
    public static final int DEFAULT_SIZE = 8;
    private final int sizeLimit;
    private Map<Integer, Integer> cache;
    private List<Integer> queue;

    public LRUSolution() {
        this(DEFAULT_SIZE);
    }

    public LRUSolution(int cacheSize) {
        this.sizeLimit = cacheSize;
        this.cache = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public void put(Integer key, Integer value) {
        if (cache.size() >= this.sizeLimit) {
            this.cache.remove(this.queue.remove(0));
        }
        this.cache.put(key, value);
        this.queue.add(key);
    }

    public int get(Integer key) {
        return cache.getOrDefault(key, -1);
    }
}
