package leetcode.solution146;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache13Test {
    @Test
    public void should_get_negative_when_cache_not_hit() {
        var cache = new Solution146LRUCache13();
        assertEquals(-1, cache.get(1));
    }

    @Test
    public void should_get_value_when_cache_hit() {
        var cache = new Solution146LRUCache13();
        cache.put(1, 1);
        assertEquals(1, cache.get(1));
    }

    @Test
    public void should_expire_lru_when_put_value_exceeds_limit(){

        var cache = new Solution146LRUCache13(1);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
    }
    @Test
    public void should_switch_lru_when_get_value(){

        var cache = new Solution146LRUCache13(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);// 2 becomes LRU
        cache.put(3, 3);
        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2));
        assertEquals(3, cache.get(3));
    }
}
