package leetcode.solution146.performance;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache6Test {
    @Test
    public void should_get_negative_when_empty() {
        Assert.assertEquals(-1, new Solution146LRUCache6().get(1));
    }

    @Test
    public void should_get_when_cached() {
        Solution146LRUCache6 lruCache = new Solution146LRUCache6();
        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1));
    }

    @Test
    public void  should_expire_coldest_when_exceeding_cache_capacity() {
        Solution146LRUCache lruCache = new Solution146LRUCache6(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        assertEquals(-1, lruCache.get(1));
        assertEquals(2, lruCache.get(2));
        assertEquals(3, lruCache.get(3));
    }
}