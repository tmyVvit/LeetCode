package Huawei.niuke;

import java.util.Scanner;

public class HJ16ShoppingList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt() / 10;
        int m = in.nextInt();

        int[][] prices = new int[m][3];
        int[][] priorities = new int[m][3];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt() / 10, b = in.nextInt(), c = in.nextInt();
            if (c == 0) {
                prices[i][0] = a;
                priorities[i][0] = b * a;
            } else {
                if (prices[c - 1][1] == 0) {
                    prices[c - 1][1] = a;
                    priorities[c - 1][1] = b * a;
                } else {
                    prices[c - 1][2] = a;
                    priorities[c - 1][2] = b * a;
                }

            }
        }

        // dp[i] 表示选择第 i 个
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = n; j > 0; j--) {
                int p0 = prices[i][0], p1 = prices[i][1], p2 = prices[i][2];
                int po0 = priorities[i][0], po1 = priorities[i][1], po2 = priorities[i][2];

                dp[j] = j >= p0 ? Math.max(dp[j - p0] + po0, dp[j]) : dp[j];
                dp[j] = j >= (p0 + p1) ? Math.max(dp[j - p0 - p1] + po0 + po1, dp[j]) : dp[j];
                dp[j] = j >= (p0 + p2) ? Math.max(dp[j - p0 - p2] + po0 + po2, dp[j]) : dp[j];
                dp[j] = j >= (p0 + p1 + p2) ? Math.max(dp[j - p0 - p1 - p2] + po0 + po1 + po2, dp[j]) : dp[j];
            }
        }


        System.out.println(dp[n] * 10);
    }

    private static int max(int... nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}
