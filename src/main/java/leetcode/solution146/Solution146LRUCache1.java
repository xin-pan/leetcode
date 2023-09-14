package leetcode.solution146;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
class Solution146LRUCache1 extends Solution146LRUCacheAbstract {
    DoubleLinkedList cache;
    Map<Integer, Node> map;
    int capacity;

    public Solution146LRUCache1(int capacity) {
        super(capacity);
        cache = new DoubleLinkedList();
        map = new HashMap<>();
    }

    @Override
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            // remove
            cache.remove(node);
            map.remove(key);

            put(key, node.value);
            return node.value;
        }
    }

    @Override
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // remove
            cache.remove(node);
            map.remove(key);
        } else if (cache.size == capacity) {
            Node leastUsed = cache.removeTail();
            map.remove(leastUsed.key);
        }
        Node x = new Node(key, value);
        map.put(key, x);
        cache.insertHead(x);
    }

    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList {
        private Node head;
        private Node tail;
        int size = 0;

        public void insertHead(Node node) {
            if (size == 0) {
                head = node;
                tail = node;
            } else {
                Node oldHead = head;
                this.head = node;
                this.head.next = oldHead;
                oldHead.prev = this.head;
            }
            size++;
        }

        public void remove(Node node) {
            if (node == tail) {
                removeTail();
                return;
            }
            if (node == head) {
                removeHead();
                return;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeTail() {
            Node oldTail = this.tail;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            return oldTail;
        }

        public void removeHead() {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }
    }
}
