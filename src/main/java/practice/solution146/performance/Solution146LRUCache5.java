package practice.solution146.performance;


import practice.solution146.Solution146LRUCacheAbstract;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache5 extends Solution146LRUCacheAbstract {

    DoubleLinkedList sortedCache = new DoubleLinkedList();
    Map<Integer, Node> cache = new HashMap<>();

    public Solution146LRUCache5() {
        this(5);
    }

    public Solution146LRUCache5(int capacity) {
        super(capacity);
    }

    @Override
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            this.sortedCache.delete(existingNode);

            Node node = this.sortedCache.attachHead(key, existingNode.value);
            this.cache.put(key, node);
        }
        return this.cache.getOrDefault(key, new Node(-1, -1)).value;
    }

    @Override
    public void put(int key, int value) {
        Node node = this.sortedCache.attachHead(key, value);
        this.cache.put(key, node);

        if (this.cache.size() > capacity) {
            cache.remove(sortedCache.tail.key);
            sortedCache.removeTail();
        }
    }

    class DoubleLinkedList {
        Node head;
        Node tail;

        Node attachHead(int key, int value) {
            Node node = new Node(key, value);
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            if (tail == null) {
                tail = node;
            }
            return node;
        }

        public void delete(Node node) {
            if (node == head && node == tail) {
                head = null;
                tail = null;
            } else if (node != head && node == tail) {
                tail = tail.prev;
                tail.next = null;
            } else if (node == head && node != tail) {
                head = head.next;
                head.prev = null;
            } else {
                node.next.prev = node.prev;
                node.prev.next = node.next;
            }
        }

        public void removeTail() {
            delete(sortedCache.tail);
        }
    }

    class Node {
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
