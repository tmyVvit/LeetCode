package partitionArrayForMaximumSum;

public class Solution {
    // 给你一个整数数组 arr，请你将该数组分隔为长度 **最多** 为 k 的一些（连续）子数组。
    // 分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        int max = 0;
        // 对于 i < k 的情况，dp[i] = max * (i + 1)，max 就是 0..i 的最大值
        for (int i = 0; i < k; i++) {
            max = Math.max(max, arr[i]);
            dp[i] = max * (i + 1);
        }

        // 当 i >= k 时
        for (int i = k; i < dp.length; i++) {
            max = arr[i];

            // 最长子数组长度是 k，所以可以以 i 为子数组右边界进行计算
            // 从长度为 1 到 k 进行划分，对每个进行计算，dp[i] 取其中最大值
            for (int j = 1; j <= k; j++) {
                max = Math.max(max, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], dp[i - j] + max * j);
            }
        }

        return dp[dp.length - 1];
    }
}
