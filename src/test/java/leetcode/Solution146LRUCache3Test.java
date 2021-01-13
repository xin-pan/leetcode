package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache3Test {
    @Test
    public void should_get_negative_when_empty() {
        assertEquals(-1, new Solution146LRUCache3(1).get(1));
    }

    @Test
    public void should_get_cached_value() {
        Solution146LRUCache3 solution146LRUCache = new Solution146LRUCache3(1);
        solution146LRUCache.put(1, 1);
        solution146LRUCache.put(2, 2);
        assertEquals(1, solution146LRUCache.get(1));
        assertEquals(2, solution146LRUCache.get(2));
    }

//    @Test
//    public void should_expire_cached_value_when_exceeding_capacity() {
//        Solution146LRUCache3 solution146LRUCache = new Solution146LRUCache3(1);
//        solution146LRUCache.put(1, 1);
//        solution146LRUCache.put(2, 2);
//        solution146LRUCache.put(3, 3);
//        assertEquals(-1, solution146LRUCache.get(1));
//        assertEquals(2, solution146LRUCache.get(2));
//        assertEquals(3, solution146LRUCache.get(3));
//    }
}