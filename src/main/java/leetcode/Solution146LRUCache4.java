package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache4 {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int get(int key) {
        return cache.getOrDefault(1, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
