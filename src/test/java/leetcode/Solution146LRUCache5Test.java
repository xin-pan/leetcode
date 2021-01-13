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
}