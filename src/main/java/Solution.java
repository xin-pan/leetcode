import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int frequency = a.containsKey(nums[i]) ? a.get(nums[i]) + 1 : 1;
            a.put(nums[i], frequency);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(a.entrySet());
        Comparator<Map.Entry<Integer, Integer>> entryComparator = (o1, o2) -> o2.getValue() - o1.getValue();
        entryList.sort(entryComparator);
        List<Map.Entry<Integer, Integer>> resultEntryList = entryList.subList(0, k);
        return resultEntryList.stream().map(entry -> entry.getKey().intValue()).mapToInt(Integer::intValue).toArray();
    }


    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (!containsDuplicateChar(s, i, j)) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }

    private boolean containsDuplicateChar(String s, int start, int end) {
        Set<Character> existing = new HashSet<>();
        for (int i = start; i < end; i++) {
            char o = s.charAt(i);
            if (existing.contains(o)) {
                return true;
            } else {
                existing.add(o);
            }
        }
        return false;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        String result = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            int left, right;
            for (left = i - 1, right = i + 1; left >= 0 && right < s.length(); left--, right++) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
            }
            if (right - left - 1 > result.length()) {
                result = s.substring(left + 1, right);
            }
            for (left = i - 1, right = i; left >= 0 && right < s.length(); left--, right++) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
            }
            if (right - left - 1 > result.length()) {
                result = s.substring(left + 1, right);
            }
        }
        return result;
    }

    public int myAtoi(String str) {
        int result = 0;
        if (str != null) {
            str = str.trim();
            boolean negative = false;
            if (str.startsWith("-")) {
                str = str.substring(1);
                negative = true;
            } else if (str.startsWith("+")) {
                str = str.substring(1);
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                    str = str.substring(0, i);
                }
            }
            if (str.length() > 0) {
                str = negative ? "-" + str : str;
                try {
                    result = Integer.valueOf(str);
                } catch (NumberFormatException e) {
                    if (negative) {
                        result = Integer.MIN_VALUE;
                    } else {
                        result = Integer.MAX_VALUE;
                    }
                }
            }
        }
        return result;
    }


}
