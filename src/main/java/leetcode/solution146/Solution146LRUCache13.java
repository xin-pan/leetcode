package leetcode.solution146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution146LRUCache13 {
    public static final int DEFAULT_VALUE = -1;
    public static final int DEFAULT_LIMIT = 8;
    private final int limit;
    Map<Integer, Integer> cache = new HashMap<>();
    List<Integer> queue = new LinkedList();

    public Solution146LRUCache13(int limit) {
        this.limit = limit;
    }

    public Solution146LRUCache13() {
        this(DEFAULT_LIMIT);
    }

    public int get(int key) {
        this.markAsRU(key);
        return cache.getOrDefault(key, DEFAULT_VALUE);
    }

    public void put(int key, int value) {
        if (cache.size() >= limit) {
            this.removeLRU();
        }
        cache.put(key, value);
        this.markAsRU(key);
    }

    private void markAsRU(int key) {
        queue = this.queue.stream().dropWhile(x -> x.intValue() == key).collect(Collectors.toList());
        queue.add(key);//Recent used in the tail of the queue
    }

    private void removeLRU() {
        Integer lruKey = this.queue.get(0);
        this.queue.remove(0);//LRU is the head of the queue
        this.cache.remove(lruKey);
    }
}
