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
}