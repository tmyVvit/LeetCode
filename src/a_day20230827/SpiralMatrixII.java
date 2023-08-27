package a_day20230827;

// https://leetcode.cn/problems/spiral-matrix-ii/description/
public class SpiralMatrixII {

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int dir = 0;

        int i = 0;
        int j = 0;
        int num = 1;
        while (num <= n * n) {
            matrix[i][j] = num++;
            int nextI = i + dirs[dir][0];
            int nextJ = j + dirs[dir][1];
            if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || matrix[nextI][nextJ] != 0) {
                dir = (dir + 1) % 4;
            }
            i += dirs[dir][0];
            j += dirs[dir][1];
        }
        return matrix;
    }
}
