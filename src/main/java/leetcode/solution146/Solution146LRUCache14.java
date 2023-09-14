package leetcode.solution146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution146LRUCache14 {
    public static final int DEFAULT_LIMIT = 8;
    private final int limit;
    private Map<Integer, Integer> cache = new HashMap<>();
    private List<Integer> queue = new LinkedList<>();

    public Solution146LRUCache14(int limit) {
        this.limit = limit;
    }

    public Solution146LRUCache14() {
        this(DEFAULT_LIMIT);
    }

    public int get(int key) {
        refreshQueue(key);
        return cache.getOrDefault(key, -1);
    }

    private void refreshQueue(int key) {
        this.queue = this.queue.stream().dropWhile(x -> x.intValue() == key).collect(Collectors.toList());
    }

    public void put(int key, int value) {
        if (cache.size() >= limit) {
            this.removeLRU();
        }
        this.cache.put(key, value);
        this.queue.add(key);
    }

    private void removeLRU() {
        Integer lruKey = queue.get(0);
        cache.remove(lruKey);
        queue.remove(0);
    }
}
