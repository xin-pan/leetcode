package leetcode;

import leetcode.Solution15;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution15Test {

    @Test
    public void threeSum() {
        List<Integer> e1 = List.of(-1, -1, 2);
        List<Integer> e2 = List.of(-1, 0, 1);
        assertEquals(List.of(e2, e1), Solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));


        assertEquals(List.of(List.of(0, 0, 0)), Solution15.threeSum(new int[]{0, 0, 0}));
    }
}