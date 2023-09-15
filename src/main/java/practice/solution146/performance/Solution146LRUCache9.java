package practice.solution146.performance;

import practice.solution146.Solution146LRUCacheAbstract;

import java.util.HashMap;
import java.util.Map;

// 26 min
public class Solution146LRUCache9 extends Solution146LRUCacheAbstract {

    private Map<Integer, Node> cache = new HashMap<>();
    private DoubleLinked sorted = new DoubleLinked();

    private static class Node {
        Node prev, next;
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoubleLinked {
        Node first, last;
//        int size = 0;

        public void remove(Node node) {
            if (node.prev == null) {
                //removing first
                first = node.next;
            } else {
                node.prev.next = node.next;
            }
            if (node.next == null) {
                last = node.prev;
            } else {
                node.next.prev = node.prev;
            }
//            size--;
        }

        public void addLast(Node node) {
            if (first == null) {
                first = node;
            } else {
                node.prev = last;
                last.next = node;
            }
            last = node;
//            size++;
        }
    }

    public Solution146LRUCache9(int capacity) {
        super(capacity);
    }

    @Override
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            sorted.remove(node);
            sorted.addLast(node);
            return node.value;
        } else {
            return -1;
        }
    }

    @Override
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            sorted.remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        sorted.addLast(node);

        if (cache.size() > capacity) {
            cache.remove(sorted.first.key);
            sorted.remove(sorted.first);
        }
    }
}
