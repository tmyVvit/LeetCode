package jianzhi;

public class FindTargetSum {
    // 暴力回溯
    public int findTargetSumWays0(int[] nums, int target) {
        return backtrace(0, 0, nums, target);
    }

    private int backtrace(int idx, int sum, int[] nums, int target) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }
        return backtrace(idx + 1, sum + nums[idx], nums, target)
                + backtrace(idx + 1, sum - nums[idx], nums, target);
    }

    // dp
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        // 设 nums 中选取的 - 的数的和为 neg，那么选取的 + 的数的和为 sum - neg
        // 那么就有：sum - neg - neg = target  --> neg = (sum - target) / 2
        if (target > sum || ((sum - target) & 1) == 1) {
            return 0;
        }
        int neg = (sum - target) >> 1;

        // dp[i][j] 代表数组下标 [0,i] 的和为 j 的个数
        // dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j]
        // 由于只跟上一层有关，所以可以优化成一行
        int[] dp = new int[neg + 1];
        dp[0] = 1;

        for (int n : nums) {
            for (int j = neg; j >= n; j--) {
                dp[j] += dp[j - n];
            }
        }
        return dp[neg];

    }
}
