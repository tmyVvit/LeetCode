package jianzhi;

public class NumberOfUniquePaths {

    public static void main(String[] args) {
        NumberOfUniquePaths s = new NumberOfUniquePaths();
        System.out.println(s.uniquePaths(19, 10));

    }

    private int num = 0;

    public int uniquePaths2(int m, int n) {
        backtrack(1, 1, m, n);
        return num;
    }

    private void backtrack(int x, int y, int m, int n) {
        if (x > m || y > n) {
            return;
        }
        if (x == m && y == n) {
            num++;
            return;
        }

        backtrack(x + 1, y, m , n);
        backtrack(x, y + 1, m , n);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


}
