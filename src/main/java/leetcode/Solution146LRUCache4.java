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
    }

    class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
