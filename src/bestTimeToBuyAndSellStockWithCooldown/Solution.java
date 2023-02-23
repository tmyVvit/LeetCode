package bestTimeToBuyAndSellStockWithCooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        // dp0[i] 持有股票
        // dp1[i] 未持有股票，且没有冷冻期
        // dp2[i] 未持有股票，且有冷冻期
        int len = prices.length;
        int[] dp0 = new int[len];
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];

        dp0[0] = -prices[0];
        dp1[0] = dp2[0] = 0;
        for (int i = 1; i < len; i++) {
            dp2[i] = dp0[i - 1] + prices[i];
            dp1[i] = Math.max(dp1[i - 1], dp2[i - 1]);
            dp0[i] = Math.max(dp0[i-1], dp1[i-1] - prices[i]);
        }
        return Math.max(dp1[len - 1], dp2[len - 1]);
    }
}
