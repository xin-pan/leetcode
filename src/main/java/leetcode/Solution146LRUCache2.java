package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
class Solution146LRUCache2 extends Solution146LRUCacheAbstract {
    DoubleLinkedList sortedNodes = new DoubleLinkedList();
    private Map<Integer, Node> cache = new HashMap<>();

    public Solution146LRUCache2(int capacity) {
        super(capacity);
    }

    @Override
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            sortedNodes.remove(node);
            Node newHead = sortedNodes.insertHead(node.key, node.value);
            cache.put(key, newHead);
            return node.value;
        } else {
            return -1;
        }
    }

    @Override
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            cache.remove(node);
            sortedNodes.remove(node);
        }
        Node newHead = sortedNodes.insertHead(key, value);
        cache.put(key, newHead);

        if (cache.size() > capacity) {
            cache.remove(sortedNodes.tail.key);
            sortedNodes.remove(sortedNodes.tail);
        }
    }

    private class DoubleLinkedList {
        private Node head;
        private Node tail;

        public void remove(Node node) {
            if (node.prev == null) {
                // removing head node
                head = node.next;
                if (head != null) {
                    // head is not the only node
                    head.prev = null;
                } else {
                    // head is the only node
                    tail = null;
                }
            } else {
                node.prev.next = node.next;
            }
            if (node.next == null) {
                // removing tail node
                tail = node.prev;
                if (tail != null) {
                    // tail is not the only node
                    tail.next = null;
                } else {
                    // tail is the only node
                    head = null;
                }
            } else {
                node.next.prev = node.prev;
            }
        }

        public Node insertHead(int key, int value) {
            Node node = new Node(key, value);
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            if (head.next == null) {
                tail = head;
            }
            return node;
        }
    }

    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }
}
