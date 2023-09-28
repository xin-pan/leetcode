package practice;

import java.util.HashMap;
import java.util.Map;

public class LRUSolution {
    private Map<Integer, Integer> cache = new HashMap();

    public void put(int key, int value) {
        this.cache.put(key, value);
    }

    public int get(int key) {
        return this.cache.get(key);
    }
}
