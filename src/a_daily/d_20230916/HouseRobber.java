package a_daily.d_20230916;

// https://leetcode-cn.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {
        int count = nums.length;
        if (count == 1) {
            return nums[0];
        } else if (count == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[count];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < count; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[count-1];
    }
}
