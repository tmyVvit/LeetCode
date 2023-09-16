package a_daily.d_20230829;

import java.util.Arrays;


// https://leetcode.cn/problems/binary-trees-with-factors/description/
public class BinaryTreesWithFactor {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        System.out.println("a" + 'b');
    }

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        long[] dp = new long[len];
        long sum = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;

            for (int l = 0, r = i - 1; l <= r; l++) {
                while (l <= r && (long) arr[l] * arr[r] > arr[i]) {
                    r--;
                }
                if (l <= r && (long) arr[l] * arr[r] == arr[i]) {
                    dp[i] = (dp[i] + dp[l] * dp[r] * (l == r ? 1 : 2)) % MOD;
                }
            }
            sum = (sum + dp[i]) % MOD;
        }
        return (int) sum;
    }
}
