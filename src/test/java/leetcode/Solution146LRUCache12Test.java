package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class Solution146LRUCache12Test {
    @Test
    public void should_not_get_value_when_not_cached(){
        var solution146LRUCache12 = new Solution146LRUCache12();
        assertNull(solution146LRUCache12.get("1"));
    }
}
