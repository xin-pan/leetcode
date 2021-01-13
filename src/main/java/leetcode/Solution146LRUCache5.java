package leetcode;


import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache5 {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int get(int key) {
        return this.cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.cache.put(key, value);
    }
}
