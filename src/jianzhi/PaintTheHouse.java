package jianzhi;

public class PaintTheHouse {

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i - 1][2];
        }

        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
    }


    public int minCost2(int[][] costs) {
        int n = costs.length;
        int dp0 = 0, dp1 = 0, dp2 = 0;

        for (int[] cost : costs) {
            int tmp0 = Math.min(dp1, dp2) + cost[0];
            int tmp1 = Math.min(dp0, dp2) + cost[1];
            int tmp2 = Math.min(dp0, dp1) + cost[2];
            dp0 = tmp0;
            dp1 = tmp1;
            dp2 = tmp2;
        }

        return Math.min(Math.min(dp0, dp1), dp2);
    }

}
