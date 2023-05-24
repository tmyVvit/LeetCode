package jumpFrog;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public double frogPosition(int n, int[][] edges, int t, int target) {
        int[] possibility = new int[t];
        boolean[] visited = new boolean[n + 1];
        int[][] map = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            int l = edge[0], r = edge[1];
            map[l][r] = 1;
            map[r][l] = 1;
        }


        boolean res = dfs(map, visited, t, target, possibility, 1, 0);
        if (res) {
            double ans = 1;
            for (int p : possibility) {
                ans *= (1 / (double) p);
            }
            return ans;
        }
        return 0;
    }

    private boolean dfs(int[][] edges, boolean[] visited, int t, int target, int[] possibility, int current, int currentIdx) {
        if (currentIdx == t) {
            return current == target;
        }
        int[] possible = edges[current];
        visited[current] = true;

        List<Integer> next = new ArrayList<>();

        for (int i = 1; i < possible.length; i++) {
            if (possible[i] == 1 && !visited[i]) {
                next.add(i);
            }
        }

        if (next.isEmpty()) {
            if (current == target) {
                for (int i = currentIdx; i < possibility.length; i++) {
                    possibility[i] = 1;
                }
                return true;
            }
            return false;
        }

        possibility[currentIdx] = next.size();
        for (int ne : next) {
            if (dfs(edges, visited, t, target, possibility, ne, currentIdx + 1)) {
                return true;
            }
        }

        visited[current] = false;

        return false;
    }

}
