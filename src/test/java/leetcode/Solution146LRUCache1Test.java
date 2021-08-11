package leetcode;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache1Test {
    @Test
    public void should_get_negative_when_empty() {
        assertEquals(-1, new Solution146LRUCache1(1).get(1));
    }

    @Test
    @Ignore
    public void should_get_when_within_capacity() {
        Solution146LRUCache lruCache = new Solution146LRUCache1(2);
        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1));
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1));
        assertEquals(2, lruCache.get(2));
    }

//    @Test
//    public void should_get_negative_when_exceeding_capacity() {
//        Solution146LRUCache lruCache = new Solution146LRUCache1(2);
//        lruCache.put(1, 1);
//        assertEquals(1, lruCache.get(1));
//        lruCache.put(2, 2);
//        assertEquals(1, lruCache.get(1));
//        lruCache.put(3, 3);
//        assertEquals(1, lruCache.get(1));
//        assertEquals(-1, lruCache.get(2));
//        assertEquals(3, lruCache.get(3));
//    }
}