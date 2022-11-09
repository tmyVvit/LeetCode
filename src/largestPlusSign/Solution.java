package largestPlusSign;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (n == 1) return 0;
        if (n == 2) {
            if (mines.length == 4) return 0;
            return 1;
        }

        int[][] values = new int[n][n];
        for (int[] mine : mines) {
            values[mine[0]][mine[1]] = -1;
        }

        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];

        // left
        // up
        for (int i = 0; i < n; i++) {
            left[i][0] = values[i][0] == -1 ? 0 : 1;
            up[0][i] = values[0][i] == -1 ? 0 : 1;
            for (int j = 1; j < n; j++) {
                left[i][j] = values[i][j] == -1 ? 0 : 1 + left[i][j - 1];
                up[j][i] = values[j][i] == -1 ? 0 : 1 + up[j - 1][i];
            }
        }

        // right
        // down
        for (int i = 0; i < n; i++) {
            right[i][n - 1] = values[i][n - 1] == -1 ? 0 : 1;
            down[n - 1][i] = values[n - 1][i] == -1 ? 0 : 1;
            for (int j = n - 2; j >= 0; j--) {
                right[i][j] = values[i][j] == -1 ? 0 : 1 + right[i][j + 1];
                down[j][i] = values[j][i] == -1 ? 0 : 1 + down[j + 1][i];
            }
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = min(left[i][j], right[i][j], up[i][j], down[i][j]);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    private int min(int i1, int i2, int i3, int i4) {
        return Math.min(Math.min(i1, i2), Math.min(i3, i4));
    }
}
