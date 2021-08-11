package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution146LRUCache7Test {
    @Test
    public void should_get_negative_when_out_of_cache() {
        Solution146LRUCache lruCache = new Solution146LRUCache7(2);
        lruCache.put(1, 1);
        assertEquals(-1, lruCache.get(2));
    }
}