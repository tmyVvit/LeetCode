package jianzhi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                List<int[]> islands = new ArrayList<>();
                dfs(i, j, m, n, grid, visited, islands);
                max = Math.max(max, islands.size());
            }
        }
        return max;
    }

    private void dfs(int i, int j, int m, int n, int[][] grid, int[][] visited, List<int[]> islands) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1 || visited[i][j] == 1) {
            return;
        }

        visited[i][j] = 1;
        islands.add(new int[]{i, j});
        dfs(i, j + 1, m, n, grid, visited, islands);
        dfs(i, j - 1, m, n, grid, visited, islands);
        dfs(i - 1, j, m, n, grid, visited, islands);
        dfs(i + 1, j, m, n, grid, visited, islands);
    }
}
