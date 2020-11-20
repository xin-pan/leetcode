import java.util.List;

public class SolutionAmazonInterviewQ1 {

    public static long getSongPairCount(List<Integer> songs) {
        int result = 0;
        for (int i = 1; i < songs.size() - 1; i++) {
            for (int j = i + 1; j < songs.size(); j++) {
                if ((songs.get(i) + songs.get(j)) % 60 == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
