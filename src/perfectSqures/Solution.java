package perfectSqures;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int k = 1; k*k <= i; k++) {
                min = Math.min(min, dp[i-k*k]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
