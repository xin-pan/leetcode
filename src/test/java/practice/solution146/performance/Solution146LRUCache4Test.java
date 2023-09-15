package practice.solution146.performance;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache4Test {
    @Test
    public void should_get_negative_when_empty() {
        Assert.assertEquals(-1, new Solution146LRUCache4(3).get(1));
    }

    @Test
    public void should_get_when_cached() {
        Solution146LRUCache4 solution146LRUCache = new Solution146LRUCache4(3);
        solution146LRUCache.put(1, 1);
        assertEquals(1, solution146LRUCache.get(1));
    }

    @Test
    public void should_save_temperature_when_put_once() {
        Solution146LRUCache4 solution146LRUCache = new Solution146LRUCache4(3);
        solution146LRUCache.put(1, 1);
        assertEquals(1, solution146LRUCache.temperature.hottest.value);
        assertEquals(1, solution146LRUCache.temperature.coldest.value);
    }

    @Test
    public void should_save_temperature_when_put_twice() {
        Solution146LRUCache4 solution146LRUCache = new Solution146LRUCache4(3);
        solution146LRUCache.put(1, 1);
        solution146LRUCache.put(2, 2);
        assertEquals(2, solution146LRUCache.temperature.hottest.value);
        assertEquals(1, solution146LRUCache.temperature.coldest.value);
        assertEquals(solution146LRUCache.temperature.hottest, solution146LRUCache.cache.get(solution146LRUCache.temperature.hottest.key));
        assertEquals(solution146LRUCache.temperature.coldest, solution146LRUCache.cache.get(solution146LRUCache.temperature.coldest.key));
    }

    @Test
    public void should_refresh_coldest_as_hottest_when_cache_hit() {
        Solution146LRUCache4 solution146LRUCache = new Solution146LRUCache4(3);
        solution146LRUCache.put(1, 1);
        solution146LRUCache.put(2, 2);
        solution146LRUCache.get(1);
        assertEquals(1, solution146LRUCache.temperature.hottest.value);
        assertEquals(2, solution146LRUCache.temperature.coldest.value);
        assertEquals(solution146LRUCache.temperature.hottest, solution146LRUCache.cache.get(solution146LRUCache.temperature.hottest.key));
        assertEquals(solution146LRUCache.temperature.coldest, solution146LRUCache.cache.get(solution146LRUCache.temperature.coldest.key));
    }

    @Test
    public void should_refresh_middle_node_as_hottest_when_cache_hit() {
        Solution146LRUCache4 solution146LRUCache = new Solution146LRUCache4(3);
        solution146LRUCache.put(1, 1);
        solution146LRUCache.put(2, 2);
        solution146LRUCache.put(3, 3);
        solution146LRUCache.get(2);
        assertEquals(2, solution146LRUCache.temperature.hottest.value);
        assertEquals(1, solution146LRUCache.temperature.coldest.value);
        assertEquals(solution146LRUCache.temperature.hottest, solution146LRUCache.cache.get(solution146LRUCache.temperature.hottest.key));
        assertEquals(solution146LRUCache.temperature.coldest, solution146LRUCache.cache.get(solution146LRUCache.temperature.coldest.key));
    }

    @Test
    public void should_expire_coldest_when_exceeding_cache_capacity() {
        Solution146LRUCache4 solution146LRUCache = new Solution146LRUCache4(2);
        solution146LRUCache.put(1, 1);
        solution146LRUCache.put(2, 2);
        solution146LRUCache.put(3, 3);
        assertEquals(-1, solution146LRUCache.get(1));
        assertEquals(2, solution146LRUCache.get(2));
        assertEquals(3, solution146LRUCache.get(3));
    }
}