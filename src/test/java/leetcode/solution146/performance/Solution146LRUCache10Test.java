package leetcode.solution146.performance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache10Test {

    @Test
    public void should_get_negative_when_out_of_cache() {
        Solution146LRUCache10 lruCache = new Solution146LRUCache10(2);
        lruCache.put(1, 1);
        assertEquals(-1, lruCache.get(2));
    }

    @Test
    public void should_get_value_when_within_cache() {
        Solution146LRUCache10 lruCache = new Solution146LRUCache10(2);
        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1));
    }

    @Test
    public void should_get_negative_when_cache_expires() {
        Solution146LRUCache10 lruCache = new Solution146LRUCache10(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        assertEquals(-1, lruCache.get(1));
    }

    @Test
    public void should_refresh_cache_when_used_recently() {
        Solution146LRUCache10 lruCache = new Solution146LRUCache10(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.get(1);
        lruCache.put(4, 4);
        assertEquals(1, lruCache.get(1));
        assertEquals(-1, lruCache.get(2));
    }

    @Test
    public void should_replace_cache() {
        Solution146LRUCache10 lruCache = new Solution146LRUCache10(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(2, 3);
        assertEquals(3, lruCache.get(2));
    }

    @Test
    public void should_not_expire_lru_node_when_put_duplicate() {
        Solution146LRUCache10 lruCache = new Solution146LRUCache10(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(2, 3);
        assertEquals(1, lruCache.get(1));
        assertEquals(3, lruCache.get(2));
    }
}