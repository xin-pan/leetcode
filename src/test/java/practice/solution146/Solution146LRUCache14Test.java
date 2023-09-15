package practice.solution146;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution146LRUCache14Test {
    @Test
    public void should_get_default_value_when_not_hit() {
        var cache = new Solution146LRUCache14();
        assertEquals(-1, cache.get(1));
    }

    @Test
    public void should_get_cache_value_when_key_hit() {
        var cache = new Solution146LRUCache14();
        cache.put(1, 1);
        assertEquals(1, cache.get(1));
    }

    @Test
    public void should_expire_lru_when_size_exceeds_limit_and_put_new() {

        var cache = new Solution146LRUCache14(1);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    public void should_refresh_lru_when_get_from_cache() {

        var cache = new Solution146LRUCache14(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        assertEquals(1, cache.get(1));//2,3 becomes LRU
        cache.put(4, 4);
        cache.put(5, 5);
        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2));
        assertEquals(-1, cache.get(3));
        assertEquals(4, cache.get(4));
        assertEquals(5, cache.get(5));
    }
}