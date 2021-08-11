package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution146LRUCache7 extends Solution146LRUCacheAbstract {
    private Map<Integer, Integer> cache = new HashMap<>();
    private LinkedList<Node> sorted = new LinkedList<>();

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Solution146LRUCache7(int capacity) {
        super(capacity);
    }

    @Override
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    @Override
    public void put(int key, int value) {
        if (sorted.size() >= capacity) {
            Node first = sorted.removeFirst();
            cache.remove(first.key);
        }
        cache.put(key, value);
        sorted.addLast(new Node(key, value));
    }
}
