package practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution7ReverseIntegerTest {
    @Test
    public void should_reverse_when_integer_overflows(){
        assertEquals(0, Solution7ReverseInteger.reverse(1534236469));
    }
    @Test
    public void should_reverse_when_negative_integer_overflows(){
        assertEquals(0, Solution7ReverseInteger.reverse(-1563847412));
    }
}