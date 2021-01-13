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
        Node node = new Node(value);
        cache.put(key, node);
        temperature.insertHottest(value);
    }

    class Temperature {
        Node coldest;
        Node hottest;

        void insertHottest(int value) {
            Node newHottest = new Node(value);
            hottest = newHottest;
            if (coldest == null) {
                coldest = newHottest;
            }

        }

        public void remove(Node oldNode) {
            coldest = hottest;
        }
    }

    class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
