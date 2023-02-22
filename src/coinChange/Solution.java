package coinChange;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        // dp[i] 代表凑成 i 需要的最小硬币数量
        // 如果 dp[i] == -1 说明硬币无法凑成 i
        int[] dp = new int[amount + 1] ;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                // 无法凑成 i-coin
                if (dp[i-coin] == -1) {
                    continue;
                }
                min = Math.min(min, dp[i-coin]);
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }
}
