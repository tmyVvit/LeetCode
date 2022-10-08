package maximumAscendingSubarraySum;

public class Solution2 {
    public int maxAscendingSum(int[] nums) {
        int tmp = 0, max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = nums[i] > nums[i - 1] ? tmp + nums[i] : nums[i];
            max = Math.max(tmp, max);
        }
        return max;
    }
}
