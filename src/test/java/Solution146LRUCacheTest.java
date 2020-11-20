import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCacheTest {
    @Test
    public void should_get_negative_when_empty() {
        assertEquals(-1, new Solution146LRUCache(1).get(1));
    }

    @Test
    public void should_get_negative_when_exceeding_capacity() {
        Solution146LRUCache lruCache = new Solution146LRUCache(2);
        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1));
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1));
        lruCache.put(3, 3);
        assertEquals(1, lruCache.get(1));
        assertEquals(-1, lruCache.get(2));
        assertEquals(3, lruCache.get(3));
    }

}