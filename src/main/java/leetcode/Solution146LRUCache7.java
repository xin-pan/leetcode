package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution146LRUCache7 extends Solution146LRUCacheAbstract {
    private Map<Integer, Node> cache = new HashMap<>();
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
        Node defaultValue = new Node(-1, -1);
        Node node = cache.getOrDefault(key, defaultValue);
        if (node.value != defaultValue.value) {
            sorted.remove(node);
            sorted.addLast(node);
        }
        return node.value;
    }

    @Override
    public void put(int key, int value) {
        if (sorted.size() >= capacity) {
            Node first = sorted.removeFirst();
            cache.remove(first.key);
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        sorted.addLast(node);
    }
}
