package leetcode.solution146;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache3 extends Solution146LRUCacheAbstract {
    private static final Node DEFAULT_NODE = new Node(-1, -1);
    private final Temperature temperature = new Temperature();
    private Map<Integer, Node> cache = new HashMap();

    public Solution146LRUCache3(int capacity) {
        super(capacity);
    }

    @Override
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node oldNode = cache.get(key);
            temperature.remove(oldNode);
            Node hottest = temperature.addAndMarkAsHottest(key, oldNode.value);
            cache.put(key, hottest);
        }
        return cache.getOrDefault(key, DEFAULT_NODE).value;
    }

    @Override
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node oldNode = cache.get(key);
            temperature.remove(oldNode);
        }
        Node hottest = temperature.addAndMarkAsHottest(key, value);
        cache.put(key, hottest);

        if (cache.size() > capacity) {
            cache.remove(temperature.coldest.key);
            temperature.remove(temperature.coldest);
        }
    }

    private class Temperature {
        Node hottest;
        Node coldest;

        public Node addAndMarkAsHottest(int key, int value) {
            Node node = new Node(key, value);
            node.next = hottest;

            if (hottest != null) {
                hottest.prev = node;
            }
            hottest = node;
            if (coldest == null) {
                coldest = node;
            }
            return node;
        }

        public void remove(Node node) {
            if (node == hottest && node == coldest) {
                hottest = null;
                coldest = null;
            } else if (node == hottest && node != coldest) {
                node.next.prev = null;
                hottest = node.next;
            } else if (node != hottest && node == coldest) {
                node.prev.next = null;
                coldest = node.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
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
