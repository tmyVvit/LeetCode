package jianzhi;

import java.util.Arrays;

public class MinCoinNumber {

    public static void main(String[] args) {
        MinCoinNumber s = new MinCoinNumber();
        System.out.println(s.coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {

            int min = Integer.MAX_VALUE;
            for (int c : coins) {
                int pre = i - c;
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
