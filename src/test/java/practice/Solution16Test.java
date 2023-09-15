package practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution16Test {

    @Test
    public void threeSumClosest() {
        assertEquals(2, Solution16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    @Test
    public void threeSumClosest2() {
        assertEquals(3, Solution16.threeSumClosest(new int[]{1, 1, 1, 0}, 100));
    }

    @Test
    public void threeSumClosest3() {
        assertEquals(0, Solution16.threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }
}