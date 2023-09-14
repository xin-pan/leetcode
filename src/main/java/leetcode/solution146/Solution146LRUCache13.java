package leetcode.solution146;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache13 {
    public static final int DEFAULT_VALUE = -1;
    Map<Integer, Integer> cache = new HashMap<>();

    public int get(int key) {
        return cache.getOrDefault(key, DEFAULT_VALUE);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
