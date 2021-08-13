package leetcode;

import java.util.HashMap;
import java.util.Map;

// 43 mins
public class Solution146LRUCache8 extends Solution146LRUCacheAbstract {
    private Map<Integer, Node> cache = new HashMap<>();
    private DoubleLinkedList sorted = new DoubleLinkedList();


    public Solution146LRUCache8(int capacity) {
        super(capacity);
    }

    @Override
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            sorted.remove(node);
            sorted.addLast(node);
            return node.value;
        }
    }

    @Override
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existing = cache.remove(key);
            sorted.remove(existing);
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        sorted.addLast(newNode);

        if (sorted.size > capacity) {
            Node first = sorted.removeFirst();
            cache.remove(first.key);
        }
    }

    private class Node {
        public int key;
        public int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private class DoubleLinkedList {
        private Node first;
        private Node last;
        private int size;

        public void remove(Node node) {
            if (size == 1) {
                first = null;
                last = null;
            } else {
                if (first == node) {
                    // first node
                    first = node.next;
                    first.prev = null;
                } else if (last == node) {
                    // last node
                    last = node.prev;
                    last.next = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
            }
            size--;
        }

        public void addLast(Node node) {
            if (size == 0) {
                first = node;
            } else {
                last.next = node;
                node.prev = last;
            }
            last = node;
            size++;
        }

        public Node removeFirst() {
            Node oldFirst = first;
            remove(first);
            return oldFirst;
        }
    }
}
