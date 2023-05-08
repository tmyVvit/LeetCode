package jianzhi;


import java.util.Arrays;
import java.util.LinkedList;

public class DistanceInMatrix {
    public int[][] updateMatrix0(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dis = new int[m][n];
        for (int[] d : dis) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0 && dis[i][j] == Integer.MAX_VALUE) {
                    dis[i][j] = 0;
                    LinkedList<int[]> level = new LinkedList<>();
                    level.addLast(new int[]{i, j, 0});
                    while (!level.isEmpty()) {
                        int[] po = level.pollFirst();
                        for (int[] step : next) {
                            int ni = po[0] + step[0];
                            int nj = po[1] + step[1];
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n && mat[ni][nj] == 1 && po[2] + 1 < dis[ni][nj]) {
                                dis[ni][nj] = po[2] + 1;
                                level.addLast(new int[]{ni, nj, dis[ni][nj]});
                            }
                        }
                    }
                }
            }
        }
        return dis;
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dis = new int[m][n];
        for (int[] d : dis) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        LinkedList<int[]> level = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dis[i][j] = 0;
                    level.addLast(new int[]{i, j, 0});
                }
            }
        }

        while (!level.isEmpty()) {
            int[] po = level.pollFirst();
            for (int[] step : next) {
                int ni = po[0] + step[0];
                int nj = po[1] + step[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && mat[ni][nj] == 1 && po[2] + 1 < dis[ni][nj]) {
                    dis[ni][nj] = po[2] + 1;
                    level.addLast(new int[]{ni, nj, dis[ni][nj]});
                }
            }
        }

        return dis;
    }

}
