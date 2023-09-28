package practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUSolutionTest {
    @Test
    public void should_get_cached_when_hit(){
        var cache = new LRUSolution();
        cache.put(Integer.valueOf(1), Integer.valueOf(1));
        assertEquals(1, cache.get(Integer.valueOf(1)));
    }

    @Test
    public void should_get_negative_when_not_hit(){
        var cache = new LRUSolution();
        assertEquals(-1, cache.get(Integer.valueOf(1)));
    }
    @Test
    public void should_get_negative_when_head_when_cache_size_exceeds(){
        var cache = new LRUSolution(1);
        cache.put(1,1);
        cache.put(2,2);
        assertEquals(-1, cache.get(Integer.valueOf(1)));
        assertEquals(2, cache.get(Integer.valueOf(2)));
    }
    @Test
    public void should_refresh_cache_when_get_from_cache(){
        var cache = new LRUSolution(2);
        cache.put(1,1);
        cache.put(2,2);
        // cache refreshed, 1 becomes the last used
        assertEquals(1, cache.get(Integer.valueOf(1)));

        cache.put(3,3);
        assertEquals(1, cache.get(Integer.valueOf(1)));
        assertEquals(-1, cache.get(Integer.valueOf(2)));
        assertEquals(3, cache.get(Integer.valueOf(3)));
    }
}