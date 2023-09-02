package a_day20230902;

import java.util.Arrays;

// https://leetcode.cn/problems/coin-change/description/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int pre = i - coin;
                if (pre >= 0 && dp[pre] != -1) {
                    min = Math.min(min, dp[pre] + 1);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min;
            }
        }

        return dp[amount];
    }
}
