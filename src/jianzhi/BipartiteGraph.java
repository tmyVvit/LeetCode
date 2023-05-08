package jianzhi;


public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                if (!dfs(i, 1, colors, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int i, int color, int[] colors, int[][] graph) {
        colors[i] = color;
        int neighbour = color == 1 ? 2 : 1;
        for (int n : graph[i]) {
            if (colors[n] == 0) {
                if (!dfs(n, neighbour, colors, graph)) {
                    return false;
                }
            } else if (colors[n] == color) {
                return false;
            }
        }
        return true;
    }

}
