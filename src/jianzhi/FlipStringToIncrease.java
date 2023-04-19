package jianzhi;

public class FlipStringToIncrease {

    public static void main(String[] args) {
        FlipStringToIncrease flip = new FlipStringToIncrease();
        System.out.println(flip.minFlipsMonoIncr("00110"));

    }

    public int minFlipsMonoIncr(String s) {
        int start = 0, end = s.length() - 1;
        while (s.charAt(start) == '0' && start < end) {
            start++;
        }
        while (s.charAt(end) == '1' && start < end) {
            end--;
        }

        s = s.substring(start, end + 1);

        int[][] dp = new int[2][s.length() + 1];

        // dp[0][i]
        // dp[1][i]
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                dp[0][i + 1] = dp[0][i];
                dp[1][i + 1] = dp[1][i] + 1;
            } else {
                dp[0][i + 1] = dp[0][i];
                // 当前是 1 时，不管前面是 0 还是 1 都可以不用翻转
                dp[1][i + 1] = Math.min(dp[1][i], dp[0][i]);
            }
        }

        return Math.min(dp[0][s.length()], dp[1][s.length()]);
    }

    public int minFlipsMonoIncr0(String s) {
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int next0, next1;
            if (ch == '0') {
                next0 = dp0;
                next1 = dp1 + 1;
            } else {
                next0 = dp0 + 1;
                // 当前是 1 时，不管前面是 0 还是 1 都可以不用翻转
                next1 = Math.min(dp0, dp1);
            }
            dp0 = next0;
            dp1 = next1;
        }
        return Math.min(dp0, dp1);
    }
}
