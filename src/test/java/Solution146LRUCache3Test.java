import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache3Test {
    @Test
    public void should_get_negative_when_empty() {
        assertEquals(-1, new Solution146LRUCache3(1).get(1));
    }

}