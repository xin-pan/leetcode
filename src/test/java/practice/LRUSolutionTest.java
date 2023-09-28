package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUSolutionTest {
    @Test
    public void should_return_cached_when_hit() {
        var cache = new LRUSolution(1);
        cache.put(1, 1);
        assertEquals(1, cache.get(1));
    }
    @Test
    public void should_return_negative_when_not_hit() {
        var cache = new LRUSolution(1);
        assertEquals(-1, cache.get(1));
    }
    @Test
    public void should_expire_head_when_exceeds_limit() {
        var cache = new LRUSolution(1);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
    }
}