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
}
