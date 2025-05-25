package hackerRank;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StringAnagramTest {
    @Test
    public void should_cal_string_anagrams() {
        String[] dictionary = {"hack", "a", "rank", "khac", "ackh", "kran", "rankhacker", "a", "ab", "ba", "stairs", "raits"};
        String[] query = {"a", "nark", "bs", "hack", "stair"};
        int[] result = StringAnagram.queryAnagramsFromDictionary(dictionary, query);
        assertArrayEquals(new int[]{2, 2, 0, 3, 1}, result);
    }

}