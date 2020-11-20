import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionAmazonInterviewQ1Test {

    @Test
    public void should_get_song_pair_count() {
        List<Integer> songs = Arrays.asList(4, 10, 50, 90, 30);
        assertEquals(2, SolutionAmazonInterviewQ1.getSongPairCount(songs));
    }
}