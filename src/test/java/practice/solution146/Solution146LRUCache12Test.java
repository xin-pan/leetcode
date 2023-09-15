package practice.solution146;

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
    public void should_expire_least_recent_put_when_cache_hit_limit(){
        var cache = new Solution146LRUCache12(2);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        assertNull(cache.get("1"));
        assertEquals("2", cache.get("2"));
        assertEquals("3", cache.get("3"));
    }

    @Test
    public void should_expire_least_recent_get_when_cache_hit_limit(){
        var cache = new Solution146LRUCache12(2);
        cache.put("1", "1");
        cache.put("2", "2");
        assertEquals("1", cache.get("1"));
        cache.put("3", "3");
        assertEquals("1", cache.get("1"));
        assertNull(cache.get("2"));
        assertEquals("3", cache.get("3"));
    }
}
