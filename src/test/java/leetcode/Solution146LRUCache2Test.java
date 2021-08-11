package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache2Test {
    @Test
    public void should_get_negative_when_empty() {
        assertEquals(-1, new Solution146LRUCache2(1).get(1));
    }

    @Test
    public void should_get_when_within_capacity() {
        Solution146LRUCacheAbstract lruCache = new Solution146LRUCache2(2);
        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1));
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1));
        assertEquals(2, lruCache.get(2));
    }

    @Test
    public void should_get_negative_when_exceeding_capacity() {
        Solution146LRUCache lruCache = new Solution146LRUCache2(2);
        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1));
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1));
        lruCache.put(3, 3);
        assertEquals(1, lruCache.get(1));
        assertEquals(-1, lruCache.get(2));
        assertEquals(3, lruCache.get(3));
    }

    @Test
    public void should_expire_cached_value_when_exceeding_capacity() {
        Solution146LRUCache solution146LRUCache = new Solution146LRUCache2(2);
        solution146LRUCache.put(1, 1);
        solution146LRUCache.put(2, 2);
        solution146LRUCache.put(3, 3);
        assertEquals(-1, solution146LRUCache.get(1));
        assertEquals(2, solution146LRUCache.get(2));
        assertEquals(3, solution146LRUCache.get(3));
    }
}