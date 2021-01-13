package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146LRUCache4 {

    public Temperature temperature = new Temperature();
    private Map<Integer, Integer> cache = new HashMap<>();

    public int get(int key) {
        return cache.getOrDefault(1, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
        temperature.hottest = new Node(value);
        temperature.coldest = new Node(value);
    }

    class Temperature {
        Node coldest;
        Node hottest;
    }

    class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
