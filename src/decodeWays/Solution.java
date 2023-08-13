package decodeWays;

/**
 * 91. 解码方法 https://leetcode.cn/problems/decode-ways/
 */
public class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.numDecodings("12"));

    }

    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int pre0 = 1, pre1 = isValid(s.substring(0, 1)) ? 1 : 0;

        for (int i = 1; i < s.length(); i++) {
            if (pre0 == 0 && pre1 == 0) {
                return 0;
            }
            int curr = 0;
            if (isValid(s.substring(i, i + 1))) {
                curr += pre1;
            }
            if (isValid(s.substring(i-1, i+1))) {
                curr += pre0;
            }
            pre0 = pre1;
            pre1 = curr;
        }
        return pre1;
    }

    public int numDecodings1(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = isValid(s.substring(0, 1)) ? 1 : 0;
        if (s.length() == 1) {
            return dp[1];
        }
        for (int i = 1; i < s.length(); i++) {
            if (dp[i] == 0 && dp[i-1] == 0) {
                break;
            }
            if (isValid(s.substring(i, i + 1))) {
                dp[i+1] += dp[i];
            }
            if (isValid(s.substring(i - 1, i + 1))) {
                dp[i+1] += dp[i-1];
            }

        }
        return dp[s.length()];
    }

    private boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() > 2) {
            return false;
        }
        if (s.charAt(0) == '0') {
            return false;
        }
        int val = Integer.parseInt(s);
        return val <= 26 && val > 0;
    }
}
