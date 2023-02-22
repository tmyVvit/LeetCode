package maximalSquare;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] matrix = new char[][]{new char[]{'1', '0', '1', '0', '0'}, new char[]{'1', '0', '1', '1', '1'}, new char[]{'1', '1', '1', '1', '1'}, new char[]{'1', '0', '0', '1', '0'}};
        System.out.println(s.maximalSquare(matrix));
    }

    // 超时
    public int maximalSquare0(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            int maxh = m - i;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int maxw = n - j;
                int len = Math.min(maxw, maxh);
                for (int k = 1; k <= len; k++) {
                    int square = square(matrix, i, j, k);
                    if (square == 0) {
                        break;
                    }
                    max = Math.max(max, square);
                }
            }
        }
        return max;
    }

    private int square(char[][] matrix, int i, int j, int l) {
        for (int a = i; a < i + l; a++) {
            for (int b = j; b < j + l; b++) {
                if (matrix[a][b] == '0') {
                    return 0;
                }
            }
        }
        return l * l;
    }

    // 动态规划 d[i][j] 表示 matrix[i][j] 为正方形右下角时，最大正方形的边长
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i-1][j-1] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                int up = dp[i-1][j];
                int left = dp[i][j-1];

                if (up == 0 || left == 0) {
                    dp[i][j] = 1;
                } else if (up == left) {
                    if (dp[i-up][j-up] >= 1) {
                        dp[i][j] = up + 1;
                    } else {
                        dp[i][j] = up;
                    }
                } else {
                    dp[i][j] = Math.min(up, left) + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
