package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int lastAdder = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (lastAdder == nums[i]) {
                continue;
            } else {
                lastAdder = nums[i];
            }
            List<List<Integer>> twoSum = twoSum(nums, i + 1, -1 * nums[i]);
            for (List<Integer> twoSumList : twoSum) {
                result.add(List.of(nums[i], twoSumList.get(0), twoSumList.get(1)));
            }
        }
        return result;
    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int sum) {
        Map<Integer, Integer> existing = new HashMap<>();
        int lastAdder = Integer.MAX_VALUE;
        boolean lastAdderMatched = false;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            if (lastAdder == nums[i] && lastAdderMatched) {
                continue;
            } else {
                lastAdder = nums[i];
            }
            int target = sum - nums[i];
            if (existing.containsKey(target)) {
                result.add(Arrays.asList(nums[existing.get(target)], nums[i]));
                lastAdderMatched = true;
            } else {
                existing.put(nums[i], i);
                lastAdderMatched = false;
            }
        }
        return result;
    }
}
