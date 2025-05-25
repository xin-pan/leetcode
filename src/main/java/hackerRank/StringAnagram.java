package hackerRank;

public class StringAnagram {
    public static void main(String[] args) {
        String[] dictionary = {"hack", "a", "rank", "khac", "ackh", "kran", "rankhacker", "a", "ab", "ba", "stairs", "raits"};
        String[] query = {"a", "nark", "bs", "hack", "stair"};
        int[] result = queryAnagramsFromDictionary(dictionary, query);
        for (int each : result) {
            System.out.println(each);
        }
    }

    private static int[] queryAnagramsFromDictionary(String[] dictionary, String[] query) {
        return new int[]{1, 2};
    }
}
