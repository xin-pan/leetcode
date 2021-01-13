package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache4 {

    public Temperature temperature = new Temperature();
    private Map<Integer, Node> cache = new HashMap<>();

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node oldNode = cache.get(key);
            temperature.remove(oldNode);
            temperature.insertHottest(oldNode.value);
        }
        return cache.getOrDefault(key, new Node(-1)).value;
    }

    public void put(int key, int value) {
        Node newHottest = temperature.insertHottest(value);
        cache.put(key, newHottest);
    }

    class Temperature {
        Node coldest;
        Node hottest;

        Node insertHottest(int value) {
            Node newHottest = new Node(value);
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
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
