package GridIllumination;

import java.util.ArrayList;
import java.util.List;

// 1001. Grid Illumination
//  On a N x N grid of cells, each cell (x, y) with 0 <= x < N and 0 <= y < N has a lamp.
//
//  Initially, some number of lamps are on.  lamps[i] tells us the location of the i-th lamp that is on.  Each lamp that is on illuminates every square on its x-axis, y-axis, and both diagonals (similar to a Queen in chess).
//
//  For the i-th query queries[i] = (x, y), the answer to the query is 1 if the cell (x, y) is illuminated, else 0.
//
//  After each query (x, y) [in the order given by queries], we turn off any lamps that are at cell (x, y) or are adjacent 8-directionally (ie., share a corner or edge with cell (x, y).)
//
//  Return an array of answers.  Each value answer[i] should be equal to the answer of the i-th query queries[i].


// update grids when get result from queries, but may out of memory
public class Solution {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        List<String> lampsLoc = initLights(lamps);
        int[][] grids = initGrids(N, lampsLoc);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = grids[queries[i][0]][queries[i][1]];
            List<String> adjacentGridsLoc = getAdjacent(queries[i][0], queries[i][1], grids.length);
            lampsLoc.removeAll(adjacentGridsLoc);
            grids = initGrids(grids.length, lampsLoc);
        }
        return result;
    }

//    private int getResultAndUpdateGrids(int[][] grids, List<String> lampsLoc, int x, int y) {
//        int result = grids[x][y];
//        List<String> adjacentGridsLoc = getAdjacent(x, y, grids.length);
//        lampsLoc.removeAll(adjacentGridsLoc);
//        grids = initGrids(grids.length, lampsLoc);
//        return result;
//    }

    private List<String> getAdjacent(int x, int y, int N) {
        List<String> adjacentLoc = new ArrayList<>();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < N && j < N)
                    adjacentLoc.add(getLampLoc(new int[]{i, j}));
            }
        }
        return adjacentLoc;
    }

    private List<String> initLights(int[][] lamps) {
        List<String> lights = new ArrayList<>();
        for (int[] lamp : lamps) {
            lights.add(getLampLoc(lamp));
        }
        return lights;
    }

    private String getLampLoc(int[] lamp) {
        return lamp[0] + "," + lamp[1];
    }

    private int[][] initGrids(int N, List<String> lampsLoc) {
        int[][] grids = new int[N][N];
        for (String lampLoc : lampsLoc) {
            String[] lamp = lampLoc.split(",");
            setLamp(grids, Integer.parseInt(lamp[0]), Integer.parseInt(lamp[1]), grids.length);
        }
        return grids;
    }

    private void setLamp(int[][] grids, int x, int y, int N) {
        for (int i = 0; i < N; i++) {
            grids[x][i] = 1;
        }
        for (int i = 0; i < N; i++) {
            grids[i][y] = 1;
        }
        for (int i = x - 1, j = y - 1; i > -1 && j > -1; i--, j--) {
            grids[i][j] = 1;
        }
        for (int i = x - 1, j = y + 1; i > -1 && j < N; i--, j++) {
            grids[i][j] = 1;
        }
        for (int i = x + 1, j = y + 1; i < N && j < N; i++, j++) {
            grids[i][j] = 1;
        }
        for (int i = x + 1, j = y - 1; i < N && j > -1; i++, j--) {
            grids[i][j] = 1;
        }
    }
}
