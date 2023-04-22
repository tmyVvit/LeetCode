package jianzhi;

public class CombineString {
    // 超时
    public boolean isInterleave0(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return combine(s1, 0, s2, 0, s3, 0);
    }

    private boolean combine(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i3 == s3.length()) {
            return true;
        }
        if (i1 < s1.length()) {
            if (s1.charAt(i1) == s3.charAt(i3)) {
                boolean res = combine(s1, i1 + 1, s2, i2, s3, i3 + 1);
                if (res) {
                    return true;
                }
            }
        }
        if (i2 < s2.length()) {
            if (s2.charAt(i2) == s3.charAt(i3)) {
                boolean res = combine(s1, i1, s2, i2 + 1, s3, i3 + 1);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < s1.length() + 1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j < s2.length() + 1; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i < dp.length; i++) {
            char ch1 = s1.charAt(i - 1);
            for (int j = 1; j < dp[i].length; j++) {
                char ch2 = s2.charAt(j - 1);
                char ch3 = s3.charAt(i + j - 1);
                if (ch1 != ch3 && ch2 != ch3) {
                    dp[i][j] = false;
                } else if (ch1 == ch3 && ch2 == ch3) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (ch1 == ch3) {
                    dp[i][j] = dp[i - 1][j];
                } else if (ch2 == ch3) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        CombineString c = new CombineString();
        System.out.println(c.isInterleave("db", "b", "cbb"));

    }
}
