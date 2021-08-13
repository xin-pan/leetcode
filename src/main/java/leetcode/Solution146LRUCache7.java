package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache7 extends Solution146LRUCacheAbstract {
    private Map<Integer, Node> cache = new HashMap<>();
    private DoubleLinkedList sorted = new DoubleLinkedList();

    public Solution146LRUCache7(int capacity) {
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
        if (sorted.size >= capacity) {
            Node first = sorted.removeFirst();
            cache.remove(first.key);
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        sorted.addLast(node);
    }
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList {
        Node first;
        Node last;
        private int size = 0;

        void remove(Node node) {
            if (node.prev != null) {
                // not first node
                node.prev.next = node.next;
            } else {
                // first node
                first = node.next;
            }
            if (node.next != null) {
                // not last node
                node.next.prev = node.prev;
            } else {
                // last node
                last = node.prev;
            }
            size--;
        }

        void addLast(Node node) {
            if (size == 0) {
                first = node;
                last = node;
            } else {
                // link
                last.next = node;
                node.prev = last;

                // make the new node last one.
                last = node;
            }
            size++;
        }

        Node removeFirst() {
            Node oldFirst = this.first;
            remove(oldFirst);
            return oldFirst;
        }
    }

}
