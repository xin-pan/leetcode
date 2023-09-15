package practice.solution146;

import practice.solution146.performance.Solution146LRUCache;

public abstract class Solution146LRUCacheAbstract implements Solution146LRUCache {
    protected int capacity;

    public Solution146LRUCacheAbstract(int capacity) {
        this.capacity = capacity;
    }
}
