package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution146LRUCache4Test {
    @Test
    public void should_get_negative_when_empty() {
        assertEquals(-1, new Solution146LRUCache4().get(1));
    }

}