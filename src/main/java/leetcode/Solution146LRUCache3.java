package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache3 {
    private final int capacity;
    private final static Node DEFAULT_NODE = new Node(-1, -1);
    private DoubleLinkedList latestUsed = new DoubleLinkedList();
    private Map<Integer, Node> cache = new HashMap();

    public Solution146LRUCache3(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return cache.getOrDefault(key, DEFAULT_NODE).value;
    }

    public void put(int key, int value) {
        cache.put(key, new Node(key, value));
    }

    private class DoubleLinkedList {
        Node head;
        Node tail;
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
