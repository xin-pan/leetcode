package leetcode.solution146;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution146LRUCache14Test {
    @Test
    public void should_get_default_value_when_not_hit(){
        var cache = new Solution146LRUCache14();
        assertEquals(-1, cache.get(1));
    }

    @Test
    public void should_get_cache_value_when_key_hit(){
        var cache = new Solution146LRUCache14();
        cache.put(1,1);
        assertEquals(1, cache.get(1));
    }

}