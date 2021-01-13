package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache3 {
    private final int capacity;
    private final static Node DEFAULT_NODE = new Node(-1, -1);
    private final Temperature temperature = new Temperature();
    private Map<Integer, Node> cache = new HashMap();

    public Solution146LRUCache3(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node oldNode = cache.get(key);
            Node hottest = temperature.addAndMarkAsHottest(key, oldNode.value);
            cache.put(key, hottest);
        }
        return cache.getOrDefault(key, DEFAULT_NODE).value;
    }

    public void put(int key, int value) {
        Node hottest = temperature.addAndMarkAsHottest(key, value);
        cache.put(key, hottest);
    }

    private class Temperature {
        Node head;
        Node tail;

        public Node addAndMarkAsHottest(int key, int value) {
            Node node = new Node(key, value);
            node.next = head;

            if (head == null) {
                head = node;
            } else {
                head.prev = node;
            }
            if (tail == null) {
                tail = node;
            }
            return node;
        }
    }

    private static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
