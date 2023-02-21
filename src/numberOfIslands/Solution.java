package numberOfIslands;

public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] map = new int[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && map[i][j] == 0) {
                    count++;
                    find(i, j, m, n, grid, map, count);
                }
            }
        }
        return count;
    }

    private void find(int i, int j, int m, int n, char[][] grid, int[][] map, int count) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == '1' && map[i][j] == 0) {
            map[i][j] = count;
            // right
            find(i, j + 1, m, n, grid, map, count);
            // down
            find(i + 1, j, m, n, grid, map, count);
            // left
            find(i, j - 1, m, n, grid, map, count);
            // up
            find(i - 1, j, m, n, grid, map, count);
        }
    }
}
