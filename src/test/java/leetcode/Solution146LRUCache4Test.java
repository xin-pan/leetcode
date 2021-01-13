package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache4Test {
    @Test
    public void should_get_negative_when_empty() {
        assertEquals(-1, new Solution146LRUCache4().get(1));
    }

    @Test
    public void should_get_when_cached() {
        Solution146LRUCache4 solution146LRUCache = new Solution146LRUCache4();
        solution146LRUCache.put(1, 1);
        assertEquals(1, solution146LRUCache.get(1));
    }

    @Test
    public void should_save_temperature_when_put_once() {
        Solution146LRUCache4 solution146LRUCache = new Solution146LRUCache4();
        solution146LRUCache.put(1, 1);
        assertEquals(1, solution146LRUCache.temperature.hottest.value);
        assertEquals(1, solution146LRUCache.temperature.coldest.value);
    }
}