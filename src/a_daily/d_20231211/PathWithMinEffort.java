package a_daily.d_20231211;

// https://leetcode.cn/problems/path-with-minimum-effort/?envType=daily-question&envId=2023-12-11
public class PathWithMinEffort {

    private static final int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};


    public int minimumEffortPath(int[][] heights) {
        return binarySearch(findInitK(heights), heights);
    }

    private int binarySearch(int k, int[][] heights) {
        int l = 0, r = k;
        int row = heights.length, col = heights[0].length;
        boolean[][] visited = new boolean[row][col];
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (dfs(0, 0, row, col, heights, visited, heights[0][0], mid)) {
                r--;
            } else {
                l++;
            }
        }
        return r + 1;
    }

    private boolean dfs(int ri, int ci, int row, int col, int[][] heights, boolean[][] visited, int pre, int k) {
        int effort = Math.abs(heights[ri][ci] - pre);
        if (effort > k) {
            return false;
        }
        if (ri == row - 1 && ci == col - 1) {
            return true;
        }
        visited[ri][ci] = true;
        for (int[] dir : dirs) {
            int nr = ri + dir[0], nc = ci + dir[1];
            if (nr >= 0 && nr < row && nc >= 0 && nc < col && !visited[nr][nc]
                    && dfs(nr, nc, row, col, heights, visited, heights[ri][ci], k)) {
                visited[ri][ci] = false;
                return true;
            }

        }
        visited[ri][ci] = false;
        return false;
    }

    private int findInitK(int[][] heights) {
        int r = heights.length, c = heights[0].length;
        int k = 0, pre = heights[0][0];
        int i = 0, j = 0;
        for (; i < r; i++) {
            k = Math.max(k, Math.abs(heights[i][j] - pre));
            pre = heights[i][j];
        }
        i--;
        for (; j < c; j++) {
            k = Math.max(k, Math.abs(heights[i][j] - pre));
            pre = heights[i][j];
        }
        return k;
    }




    private int ans0 = Integer.MAX_VALUE;

    // 超时
    public int minimumEffortPath0(int[][] heights) {
        int r = heights.length, c = heights[0].length;
        dfs(0, 0, r, c, heights, 0, heights[0][0], new boolean[r][c]);
        return ans0;
    }


    private void dfs(int ri, int ci, int row, int col, int[][] heights, int max, int pre, boolean[][] visited) {
        int physical = Math.abs(heights[ri][ci] - pre);
        max = Math.max(max, physical);
        if (ri == row - 1 && ci == col - 1) {
            ans0 = Math.min(ans0, max);
        }
        visited[ri][ci] = true;
        for (int[] dir : dirs) {
            int nr = ri + dir[0];
            int nc = ci + dir[1];
            if (nr >= 0 && nr < row && nc >= 0 && nc < col && !visited[nr][nc]) {
                dfs(nr, nc, row, col, heights, max, heights[ri][ci], visited);
            }
        }
        visited[ri][ci] = false;
    }
}
