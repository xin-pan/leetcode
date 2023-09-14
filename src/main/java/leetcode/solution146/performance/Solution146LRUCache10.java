package leetcode.solution146.performance;

import java.util.HashMap;
import java.util.Map;

// 12 min
public class Solution146LRUCache10 {
    private final int capacity;

    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LinkedList {
        Node first, last;

        void addLast(Node node) {
            if (last != null) {
                last.next = node;
                node.prev = last;
            } else {
                first = node;
            }

            last = node;
        }

        void remove(Node node) {
            if (node.prev == null) {
                //first
                first = node.next;
            } else {
                node.prev.next = node.next;
            }
            if (node.next == null) {
                last = node.prev;
            } else {
                node.next.prev = node.prev;
            }
        }
    }

    public Solution146LRUCache10(int capacity) {
        this.capacity = capacity;
    }

    Map<Integer, Node> cache = new HashMap<>();
    LinkedList queue = new LinkedList();

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            queue.remove(node);
            queue.addLast(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            queue.remove(cache.get(key));
        }

        Node node = new Node(key, value);
        queue.addLast(node);
        cache.put(key, node);

        if (cache.size() > capacity) {
            cache.remove(queue.first.key);
            queue.remove(queue.first);
        }
    }
}
