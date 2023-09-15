package practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution11Test {
    @Test
    public void test1() {
        assertEquals(49, Solution11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}