package jianzhi;

public class IslandMaxArea {


    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j] == 1) {
                    continue;
                }
                max = Math.max(max, dfs(i, j, m, n, grid, visited));
            }
        }
        return max;
    }

    private int dfs(int i, int j, int m, int n, int[][] grid, int[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1 || visited[i][j] == 1) {
            return 0;
        }

        visited[i][j] = 1;
        int ans = 1;
        ans += dfs(i, j + 1, m, n, grid, visited);
        ans += dfs(i, j - 1, m, n, grid, visited);
        ans += dfs(i - 1, j, m, n, grid, visited);
        ans += dfs(i + 1, j, m, n, grid, visited);
        return ans;
    }
}
