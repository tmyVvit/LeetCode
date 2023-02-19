package minimumPathSum;

public class Solution {


    // 超出时间限制
    public int minPathSum1(int[][] grid) {
        return go(grid, 0, 0, 0);
    }

    private int go(int[][] grid, int i, int j, int sum) {
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return sum + grid[i][j];
        }
        int min = -1;
        if (i < grid.length - 1) {
            min = go(grid, i + 1, j, sum + grid[i][j]);
        }
        if (j < grid[i].length - 1) {
            int goRight = go(grid, i, j + 1, sum + grid[i][j]);
            min = min == -1 ? goRight : Math.min(min, goRight);
        }
        return min;
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i - 1 < 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j - 1 < 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
