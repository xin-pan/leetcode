package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution146LRUCache8Test {

    @Test
    public void should_get_negative_when_out_of_cache() {
        Solution146LRUCache lruCache = new Solution146LRUCache8(2);
        lruCache.put(1, 1);
        assertEquals(-1, lruCache.get(2));
    }
    @Test
    public void should_get_negative_when_within_cache() {
        Solution146LRUCache lruCache = new Solution146LRUCache8(2);
        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1));
    }
    @Test
    public void should_get_negative_when_cache_expires() {
        Solution146LRUCache lruCache = new Solution146LRUCache8(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        assertEquals(-1, lruCache.get(1));
    }
    @Test
    public void should_expire_least_recently_used() {
        Solution146LRUCache lruCache = new Solution146LRUCache8(3);
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
        Solution146LRUCache lruCache = new Solution146LRUCache8(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(2, 3);
        assertEquals(3, lruCache.get(2));
    }
    @Test
    public void should_not_expire_lru_node_when_put_duplicate() {
        Solution146LRUCache lruCache = new Solution146LRUCache8(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(2, 3);
        assertEquals(1, lruCache.get(1));
        assertEquals(3, lruCache.get(2));
    }
}