package uniquePathsIII;

// 980. 不同路径III https://leetcode.cn/problems/unique-paths-iii/
public class Solution {

    private int count;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int r = s.uniquePathsIII(grid);
        System.out.println(r);

    }

    public int uniquePathsIII(int[][] grid) {
        int[] start = null, end = null;
        int m = grid.length;
        int n = grid[0].length;

        int empty = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                }
                if (grid[i][j] == 1) {
                    start = new int[]{i, j};
                }
                if (grid[i][j] == 2) {
                    end = new int[]{i, j};
                }
            }
        }

        if (start == null || end == null) {
            return 0;
        }

        int[][] visited = new int[m][n];
        count = 0;
        reverse(start[0] + 1, start[1], m, n, grid, visited, 0, empty);
        reverse(start[0] - 1, start[1], m, n, grid, visited, 0, empty);
        reverse(start[0], start[1] + 1, m, n, grid, visited, 0, empty);
        reverse(start[0], start[1] - 1, m, n, grid, visited, 0, empty);
        return count;
    }

    private void reverse(int i, int j, int m, int n, int[][] grid, int[][] visit, int path, int target) {
        if (i < 0 || i >= m || j < 0 || j >= n || visit[i][j] == 1) {
            return;
        }
        if (grid[i][j] == 2) {
            if (path == target) {
                count++;
            }
            return;
        }

        if (grid[i][j] != 0) {
            return;
        }

        visit[i][j] = 1;
        reverse(i + 1, j, m, n, grid, visit, path + 1, target);
        reverse(i - 1, j, m, n, grid, visit, path + 1, target);
        reverse(i, j + 1, m, n, grid, visit, path + 1, target);
        reverse(i, j - 1, m, n, grid, visit, path + 1, target);
        visit[i][j] = 0;
    }
}
