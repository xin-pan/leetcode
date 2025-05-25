package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagram {
    public static void main(String[] args) {
        String[] dictionary = {"hack", "a", "rank", "khac", "ackh", "kran", "rankhacker", "a", "ab", "ba", "stairs", "raits"};
        String[] query = {"a", "nark", "bs", "hack", "stair"};
        int[] result = queryAnagramsFromDictionary(dictionary, query);
        for (int each : result) {
            System.out.println(each);
        }
    }

    public static int[] queryAnagramsFromDictionary(String[] dictionary, String[] query) {
        int[] result = new int[query.length];
        List<Map<Character, Integer>> charactorCountMapList = calcCharactorCountMapList(dictionary);

        for (Map<Character, Integer> charactorCountMap : charactorCountMapList) {
            for (int i = 0; i < query.length; i++) {
                String queryWord = query[i];
                Map<Character, Integer> charactorCountMapInQuery = calcCharactorCountMap(queryWord);
                if (charactorCountMapInQuery.equals(charactorCountMap)) {
                    result[i] = result[i] + 1;
                }
            }
        }

        return result;
    }

    private static List<Map<Character, Integer>> calcCharactorCountMapList(String[] dictionary) {
        List<Map<Character, Integer>> result = new ArrayList<>();
        for (String word : dictionary) {
            result.add(calcCharactorCountMap(word));
        }
        return result;
    }

    private static Map<Character, Integer> calcCharactorCountMap(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (char char_ : word.toCharArray()) {
            result.put(char_, result.getOrDefault(char_, 0) + 1);
        }
        return result;
    }
}
