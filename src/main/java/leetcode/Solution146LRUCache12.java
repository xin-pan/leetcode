package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution146LRUCache12 {
    public static final int DEFAULT_SIZE = 8;
    private Map<String, String> cache= new HashMap<>();
    private List<String> queue = new ArrayList<>();
    private int size;

    public Solution146LRUCache12(int size) {
        this.size = size;
    }

    public Solution146LRUCache12() {
        this(DEFAULT_SIZE);
    }

    public String get(String key) {
        this.markAsLastRecentUsed(key);
        return cache.get(key);
    }

    private void markAsLastRecentUsed(String key) {
       queue=  queue.stream().dropWhile(x->x.equals(key)).collect(Collectors.toList());
       queue.add(key);//last used in the tail of the queue
    }

    public void put(String key, String value) {
        if(cache.size()>=size){
            this.removeLeastRecentUsed();
        }
        cache.put(key, value);
        queue.add(key);
    }

    private void removeLeastRecentUsed() {
        String leastRecentUsedKey = queue.get(0);
        queue.remove(0);//least recent used is in the head of the queue
        cache.remove(leastRecentUsedKey);
    }
}
