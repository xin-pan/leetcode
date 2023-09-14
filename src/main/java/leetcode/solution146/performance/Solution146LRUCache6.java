package leetcode.solution146.performance;


import leetcode.solution146.Solution146LRUCacheAbstract;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution146LRUCache6 extends Solution146LRUCacheAbstract {

    private LinkedList sortedValue = new LinkedList();
    private Map<Integer, Integer> cache = new HashMap<>();

    public Solution146LRUCache6() {
        this(5);
    }

    public Solution146LRUCache6(int capacity) {
        super(capacity);
    }

    @Override
    public int get(int key) {

        if(cache.containsKey(key)){
            Integer cached = cache.get(key);
            sortedValue.remove(cached);
            sortedValue.addFirst(cached);
            return cached;
        }else{
            return -1;
        }
    }

    @Override
    public void put(int key, int value) {
        cache.put(key, value);
        sortedValue.addFirst(value);

        if (cache.size() > this.capacity) {
            cache.remove(sortedValue.getLast());
        }
    }
}
