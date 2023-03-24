package Huawei.niuke;

import java.util.Scanner;

public class HJ52LevenshteinDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(distance(str1, str2));
        }
    }

    private static int distance(String s1, String s2) {
        // dp[i][j] 表示 s1[0..i] 与 s2[0..j] 的最小距离
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // 空字符串到另一个字符串的距离就是这个字符串的长度
        for (int i = 0; i < s1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < s2.length() + 1; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
