package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache5Test {
    @Test
    public void should_get_negative_when_empty() {
        assertEquals(-1, new Solution146LRUCache5().get(1));
    }

    @Test
    public void should_get_when_cached() {
        Solution146LRUCache5 lruCache = new Solution146LRUCache5();
        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1));
    }

    @Test
    public void should_save_sorted_cache_when_put_once() {
        Solution146LRUCache5 lruCache = new Solution146LRUCache5();
        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1));
        assertEquals(lruCache.cache.get(1), lruCache.sortedCache.head);
        assertEquals(lruCache.cache.get(1), lruCache.sortedCache.tail);
    }

    @Test
    public void should_save_sorted_cache_when_put_twice() {
        Solution146LRUCache5 lruCache = new Solution146LRUCache5();
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(lruCache.cache.get(2), lruCache.sortedCache.head);
        assertEquals(lruCache.cache.get(1), lruCache.sortedCache.tail);
    }

    @Test
    public void should_refresh_coldest_as_hottest_when_cache_hit() {
        Solution146LRUCache5 lruCache = new Solution146LRUCache5();
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(2, lruCache.sortedCache.head.value);
        assertEquals(1, lruCache.sortedCache.tail.value);
        assertEquals(lruCache.cache.get(2), lruCache.sortedCache.head);
        assertEquals(lruCache.cache.get(1), lruCache.sortedCache.tail);
        assertEquals(1, lruCache.get(1));
        assertEquals(1, lruCache.sortedCache.head.value);
        assertEquals(2, lruCache.sortedCache.tail.value);
        assertEquals(lruCache.cache.get(1), lruCache.sortedCache.head);
        assertEquals(lruCache.cache.get(2), lruCache.sortedCache.tail);
    }

    @Test
    public void should_refresh_middle_node_as_hottest_when_cache_hit() {
        Solution146LRUCache5 lruCache = new Solution146LRUCache5();
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        assertEquals(3, lruCache.sortedCache.head.value);
        assertEquals(1, lruCache.sortedCache.tail.value);
        assertEquals(lruCache.cache.get(3), lruCache.sortedCache.head);
        assertEquals(lruCache.cache.get(1), lruCache.sortedCache.tail);
        assertEquals(2, lruCache.get(2));
        assertEquals(2, lruCache.sortedCache.head.value);
        assertEquals(1, lruCache.sortedCache.tail.value);
        assertEquals(lruCache.cache.get(2), lruCache.sortedCache.head);
        assertEquals(lruCache.cache.get(1), lruCache.sortedCache.tail);
    }

    @Test
    public void  should_expire_coldest_when_exceeding_cache_capacity() {
        Solution146LRUCache5 lruCache = new Solution146LRUCache5(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        assertEquals(3, lruCache.sortedCache.head.value);
        assertEquals(2, lruCache.sortedCache.tail.value);
        assertEquals(lruCache.cache.get(3), lruCache.sortedCache.head);
        assertEquals(lruCache.cache.get(2), lruCache.sortedCache.tail);
        assertEquals(-1, lruCache.get(1));
        assertEquals(2, lruCache.get(2));
        assertEquals(3, lruCache.get(3));
    }
}