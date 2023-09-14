package leetcode.solution146;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache11Test {

    @Test
    public void should_get_negative_when_out_of_cache() {
        Solution146LRUCache11 lruCache = new Solution146LRUCache11(2);
        assertEquals(-1, lruCache.get(2).intValue());
    }
    @Test
    public void should_get_value_when_in_cache() {
        Solution146LRUCache11 lruCache = new Solution146LRUCache11(2);
        lruCache.put(2, 123);
        assertEquals(123, lruCache.get(2).intValue());
    }
}