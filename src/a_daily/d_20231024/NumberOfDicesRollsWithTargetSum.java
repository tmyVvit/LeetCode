package a_daily.d_20231024;

public class NumberOfDicesRollsWithTargetSum {

    public static void main(String[] args) {
        NumberOfDicesRollsWithTargetSum numberOfDicesRollsWithTargetSum = new NumberOfDicesRollsWithTargetSum();
//        System.out.println(numberOfDicesRollsWithTargetSum.numRollsToTarget(1, 6, 3));
        System.out.println(numberOfDicesRollsWithTargetSum.numRollsToTarget(2, 6, 7));
        System.out.println(numberOfDicesRollsWithTargetSum.numRollsToTarget(30, 30, 500));
    }
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1000000007;
        long[][] dp = new long[n + 1][target + 1];
        for (int i = 1; i <= k && i <= target; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= target; j++) {
                for (int ki = 1; ki <= k && j - ki >= 0; ki++) {
                    dp[i][j] += dp[i-1][j-ki];
                }
                dp[i][j] %= mod;
            }
        }
        return (int) dp[n][target];
    }
}
