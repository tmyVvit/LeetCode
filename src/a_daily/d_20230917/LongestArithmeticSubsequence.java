package a_daily.d_20230917;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer>[] dp = new Map[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = nums[i] - nums[j];
                if (dp[i].containsKey(k)) {
                    continue;
                }
                if(dp[j].containsKey(k)) {
                    dp[i].put(k, Math.max(dp[j].get(k) + 1, dp[i].getOrDefault(k, 0)));
                } else {
                    dp[i].put(k, 2);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int val : dp[i].values()) {
                max = Math.max(max, val);
            }
        }
        return max;
    }
}
