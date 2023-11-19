package a_daily.d_20231115;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCity {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        FindCity fc = new FindCity();
        System.out.println(fc.findTheCity(4, edges, 4));

    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] distance = new int[n][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE/2);
        }
        for (int i = 0; i < edges.length; i++) {
            int f = edges[i][0], t = edges[i][1], w = edges[i][2];
            distance[f][t] = w;
            distance[t][f] = w;
        }

        int ans = -1, min = Integer.MAX_VALUE;
        int[][][] memory = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (j != i && dfs(n-1, i, j, distance, memory) <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= min) {
                min = cnt;
                ans = i;
            }
        }
        return ans;
    }

    private int dfs(int k, int i, int j, int[][] w, int[][][] memory) {
        if (k < 0) {
            return w[i][j];
        }
        if (memory[k][i][j] != 0) {
            return memory[k][i][j];
        }
        return memory[k][i][j] = Math.min(dfs(k-1, i, j, w, memory), dfs(k-1, i, k, w, memory) + dfs(k-1, k, j, w, memory));
    }
}
