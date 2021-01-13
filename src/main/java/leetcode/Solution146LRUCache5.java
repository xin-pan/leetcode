package leetcode;


import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache5 {

    DoubleLinkedList sortedCache = new DoubleLinkedList();
    Map<Integer, Node> cache = new HashMap<>();

    public int get(int key) {
        return this.cache.getOrDefault(key, new Node(-1)).value;
    }

    public void put(int key, int value) {
        Node node = new Node(value);
        this.cache.put(key, node);
        this.sortedCache.attachHead(node);
    }

    class DoubleLinkedList {
        Node head;
        Node tail;

        Node attachHead(Node node) {
            head = node;
            if (tail == null) {
                tail = node;
            }
            return node;
        }
    }

    private class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
