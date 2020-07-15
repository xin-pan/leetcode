import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void should_run() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] topKFrequent = new Solution().topKFrequent(nums, k);
        int[] result = {1, 2};
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], topKFrequent[i]);
        }
    }

    @Test
    public void should_calc_longest_sub_string() {
        int lengthOfLongestSubstring = new Solution().lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, lengthOfLongestSubstring);
    }

    @Test
    public void should_calc_longest_sub_string_2() {
        int lengthOfLongestSubstring = new Solution().lengthOfLongestSubstring(" ");
        assertEquals(1, lengthOfLongestSubstring);
    }

    @Test
    public void should_longestPalindrome() {
        String result = new Solution().longestPalindrome("babad");
        assertEquals("bab", result);
    }

    @Test
    public void should_longestPalindrome2() {
        String result = new Solution().longestPalindrome("cbbd");
        assertEquals("bb", result);
    }

    @Test
    public void should_longestPalindrome3() {
        String result = new Solution().longestPalindrome("ccc");
        assertEquals("ccc", result);
    }

    @Test
    public void should_myAtoi() {
        int result = new Solution().myAtoi("   -42");
        assertEquals(-42, result);
    }
}