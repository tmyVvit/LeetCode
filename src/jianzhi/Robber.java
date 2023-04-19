package jianzhi;

public class Robber {
    public int rob(int[] nums) {
        int[][] dp = new int[2][nums.length + 1];

        // dp[0][i] 偷取第 i 间房的最大值
        // dp[1][i] 不偷取第 i 间房的最大值
        for (int i = 1; i < nums.length + 1; i++) {
            dp[0][i] = nums[i - 1] + dp[1][i - 1];
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
        }
        return Math.max(dp[0][nums.length], dp[1][nums.length]);
    }

    public int rob2(int[] nums) {
        int rob = 0, nrob = 0;
        for (int num : nums) {
            int tmp = num + nrob;
            nrob = Math.max(nrob, rob);
            rob = tmp;
        }
        return Math.max(rob, nrob);
    }
}
