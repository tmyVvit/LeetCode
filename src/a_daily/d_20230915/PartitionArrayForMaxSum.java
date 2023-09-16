package a_daily.d_20230915;

// https://leetcode-cn.com/problems/partition-array-for-maximum-sum/
public class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];

        dp[0] = arr[0];
        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, arr[i]);
            dp[i] = max * (i + 1);
        }

        for (int i = k; i < arr.length; i++) {
            max = arr[i];
            for (int j = 1; j <= k; j++) {
                max = Math.max(arr[i-j+1], max);
                dp[i] = Math.max(dp[i], max * j + dp[i - j]);
            }
        }
        return dp[arr.length - 1];
    }
}
