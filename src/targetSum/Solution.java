package targetSum;

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, 0, 0, target);
    }

    private int find(int[] nums, int idx, int sum, int target) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }

        return find(nums, idx + 1, sum + nums[idx], target)
                + find(nums, idx + 1, sum - nums[idx], target);
    }


    public int findTargetSumWays0(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int number = sum - target;
        if (number < 0 || (number & 1) == 1) {
            return 0;
        }
        number >>= 1;
        // dp[i][j] 代表数组下标 [0,i] 的和为 number 的个数
        // dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j]
        int[] dp = new int[number + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = number; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[number];
    }
}
