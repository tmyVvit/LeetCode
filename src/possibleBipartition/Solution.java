package possibleBipartition;

public class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] group = new int[n + 1];
        int[][] mat = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            group[i] = 0;
        }

        for (int[] dislike : dislikes) {
            mat[dislike[0]][dislike[1]] = 1;
            mat[dislike[1]][dislike[0]] = 1;
        }

        for (int i = 0; i <= n; i++) {
            if (group[i] == 0 && !dfs(mat, group, 1, i, n)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] mat, int[] group, int g, int index, int n) {
        group[index] = g;
        for (int i = 0; i <= n; i++) {
            if (i == index) continue;
            if (mat[index][i] == 1 && group[i] == g) return false;
            if (mat[index][i] == 1 && group[i] == 0 && !dfs(mat, group, g * -1, i, n)) return false;
        }
        return true;

    }
}
