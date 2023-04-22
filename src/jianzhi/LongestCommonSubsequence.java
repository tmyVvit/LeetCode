package jianzhi;

// leetcode: 剑指 Offer II 095. 最长公共子序列
// https://leetcode.cn/problems/qJnOS7/?favorite=e8X3pBZi
public class LongestCommonSubsequence {

    // dp[i][j] 表示 text1[0..i] 与 text2[0..j] 的最长公共子序列的长度
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
