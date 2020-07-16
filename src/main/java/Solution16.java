import java.util.Arrays;

public class Solution16 {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * 示例：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int threeSumCloest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int twoSumClosest = twoSumClosest(nums, i + 1, target - nums[i]);
            int latestThreeSumClosest = nums[i] + twoSumClosest;
            if (Math.abs(latestThreeSumClosest - target) < Math.abs(threeSumCloest - target)) {
                threeSumCloest = latestThreeSumClosest;
            }
        }
        return threeSumCloest;
    }

    private static int twoSumClosest(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        int twoSumCloest = nums[left] + nums[right];
        while (left < right) {
            int twoSum = nums[left] + nums[right];
            if (twoSum > target) {
                right--;
            } else if (twoSum < target) {
                left++;
            } else {
                return target;
            }
            if (Math.abs(twoSumCloest - target) > Math.abs(twoSum - target)) {
                twoSumCloest = twoSum;
            }
        }
        return twoSumCloest;
    }
}
