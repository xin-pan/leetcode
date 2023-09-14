package leetcode.solution146;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache11 {

    private Map<Integer, Integer> cache;

    public Solution146LRUCache11(int size) {
        cache = new HashMap<>(size);
    }

    public Integer get(int key) {
        return cache.getOrDefault(key, Integer.valueOf(-1));
    }

    public void put(int key, int value) {
        this.cache.put(key, value);
    }
}
