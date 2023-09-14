package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Solution146LRUCache12Test {
    @Test
    public void should_not_get_value_when_not_cached(){
        var solution146LRUCache12 = new Solution146LRUCache12();
        assertNull(solution146LRUCache12.get("1"));
    }
    @Test
    public void should_get_value_when_cached(){
        var solution146LRUCache12 = new Solution146LRUCache12();
        solution146LRUCache12.put("1", "1");
        assertEquals("1", solution146LRUCache12.get("1"));
    }

    @Test
    public void should_expire_when_cache_hit_limit(){
        var cache = new Solution146LRUCache12(1);
        cache.put("1", "1");
        cache.put("2", "2");
        assertNull(cache.get("1"));
    }
}
