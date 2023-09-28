package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUSolutionTest {
    @Test
    public void should_return_cached_when_hit() {
        var cache = new LRUSolution();
        cache.put(1, 1);
        assertEquals(1, cache.get(1));
    }
}