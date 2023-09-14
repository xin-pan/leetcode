package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache12 {
    private Map<String, String> cache= new HashMap<>();
    public String get(String key) {
        return cache.get(key);
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }
}
