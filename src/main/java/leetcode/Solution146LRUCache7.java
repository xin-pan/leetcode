package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache7 extends Solution146LRUCacheAbstract {
    Map<Integer, Integer> cache = new HashMap<>();

    public Solution146LRUCache7(int capacity) {
        super(capacity);
    }

    @Override
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    @Override
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
