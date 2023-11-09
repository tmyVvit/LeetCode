package a_daily.d_20231109;

import java.util.ArrayList;
import java.util.List;

public class EscapeTheSpreadingFire {
    private static final int MAX = 1_000_000_000;
    private static final int[][] DIR = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        EscapeTheSpreadingFire sf = new EscapeTheSpreadingFire();
        int[][] grid = new int[][]{{0,2,0,0,1},{0,2,0,2,2},{0,2,0,0,0},{0,0,2,2,0},{0,0,0,0,0}};
        System.out.println(sf.maximumMinutes(grid));

    }

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] fire = new int[m][n]; // 记录火到每个点的时间
        List<int[]> firePoint = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                fire[i][j] = MAX;
                if (grid[i][j] == 1) {
                    firePoint.add(new int[]{i, j});
                }
            }
        }
        int time = 0;
        while (!firePoint.isEmpty()) {
            List<int[]> current = firePoint;
            firePoint = new ArrayList<>();
            for (int[] point : current) {
                int x = point[0], y = point[1];
                fire[x][y] = time;
                for (int[] dir : DIR) {
                    int xi = x + dir[0];
                    int yi = y + dir[1];
                    if (xi >= 0 && xi < m && yi >= 0 && yi < n && grid[xi][yi] == 0 && fire[xi][yi] == MAX) {
                        firePoint.add(new int[]{xi, yi});
                    }
                }
            }
            time++;
        }

        int left = 0, right = fire[0][0] == MAX ? m*n -1 : fire[0][0];
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (canReach(grid, fire, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1 < m*n-1 ? left - 1 : MAX;
    }

    private boolean canReach(int[][] grid, int[][] fire, int t) {
        List<int[]> people = new ArrayList<>();
        if (fire[0][0] < t) {
            return false;
        }
        people.add(new int[]{0, 0});
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        while (!people.isEmpty()) {
            List<int[]> level = people;
            people = new ArrayList<>();
            t++;
            for (int[] p : level) {
                visited[p[0]][p[1]] = true;
                for (int[] dir : DIR) {
                    int xn = p[0] + dir[0], yn = p[1] + dir[1];
                    if (xn >= 0 && xn < m && yn >= 0 && yn < n && !visited[xn][yn]
                            && grid[xn][yn] == 0) {
                        // 人比火先走，如果相同时间到达安全屋，是安全的
                        if (fire[xn][yn] >= t && (xn == m - 1 && yn == n - 1)) {
                            return true;
                        }
                        // 否则得比火先到该点
                        if (fire[xn][yn] > t) {
                            people.add(new int[]{xn, yn});
                        }
                    }
                }
            }
        }
        return false;
    }
}
