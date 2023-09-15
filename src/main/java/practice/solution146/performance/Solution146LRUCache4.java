package practice.solution146.performance;

import practice.solution146.Solution146LRUCacheAbstract;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache4 extends Solution146LRUCacheAbstract {

    Temperature temperature = new Temperature();
    Map<Integer, Node> cache = new HashMap<>();

    public Solution146LRUCache4(int capacity) {
        super(capacity);
    }

    @Override
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node oldNode = cache.get(key);
            temperature.remove(oldNode);
            Node node = temperature.insertHottest(key, oldNode.value);
            cache.put(key, node);
        }
        return cache.getOrDefault(key, new Node(-1, -1)).value;
    }

    @Override
    public void put(int key, int value) {
        Node newHottest = temperature.insertHottest(value, key);
        cache.put(key, newHottest);

        if (cache.size() > capacity) {
            cache.remove(temperature.coldest.key);
            temperature.remove(temperature.coldest);
        }
    }

    class Temperature {
        Node coldest;
        Node hottest;

        Node insertHottest(int value, int key) {
            Node newHottest = new Node(key, value);
            newHottest.next = hottest;
            if (hottest != null) {
                hottest.prev = newHottest;
            }
            hottest = newHottest;
            if (coldest == null) {
                coldest = newHottest;
            }

            return newHottest;
        }

        public void remove(Node toBeRemovedNode) {
            if (coldest == toBeRemovedNode && hottest != toBeRemovedNode) {
                toBeRemovedNode.prev.next = null;
                coldest = toBeRemovedNode.prev;
            } else if (coldest != toBeRemovedNode && hottest == toBeRemovedNode) {
                toBeRemovedNode.next.prev = null;
                hottest = toBeRemovedNode.next;
            } else if (coldest == toBeRemovedNode && hottest == toBeRemovedNode) {
                hottest = null;
                coldest = null;
            } else {
                toBeRemovedNode.prev.next = toBeRemovedNode.next;
                toBeRemovedNode.next.prev = toBeRemovedNode.prev;
            }
        }
    }

    class Node {
        Node prev;
        Node next;
        public int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
