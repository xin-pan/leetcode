package practice;

import java.util.HashMap;
import java.util.Map;

public class LRUSolution {
    private Map<Integer, Integer> cache;

    public LRUSolution() {
        this.cache = new HashMap<>();
    }

    public void put(Integer key, Integer value) {
        this.cache.put(key,value);
    }

    public int get(Integer key) {
        return cache.getOrDefault(key, -1);
    }
}
