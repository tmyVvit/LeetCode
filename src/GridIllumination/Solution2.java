package GridIllumination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


//  no space to store grids, just verify if the location is lighting
// still will meet time limit exceeded when N = 1,000,000,000
public class Solution2 {

    private Map<Integer, Integer> lampsX = new HashMap<>();
    private Map<Integer, Integer> lampsY = new HashMap<>();
    private Map<Integer, Integer> lampsXDiagonal = new HashMap<>();
    private Map<Integer, Integer> lampsYDiagonal = new HashMap<>();

    private List<String> lampsLoc = new ArrayList<>();
    private int size;

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        size = N;
        initLights(lamps);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = isLight(queries[i][0], queries[i][1]) ? 1 : 0;
            if (!lampsLoc.isEmpty())
                turnOffLamps(queries[i][0], queries[i][1]);
        }
        return result;
    }

    private void turnOffLamps(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i >= size || j >= size) continue;
                String lamp = getLampLoc(i, j);
                if (lampsLoc.contains(lamp)) {
                    lampsLoc.remove(lamp);
                    lampsX.put(i, Math.max(0, lampsX.get(i) - 1));
                    lampsY.put(j, Math.max(0, lampsY.get(j) - 1));
                    if (lampsXDiagonal.containsKey(i - j)) {
                        lampsXDiagonal.put(i - j, Math.max(0, lampsXDiagonal.get(i - j) - 1));
                    }
                    if (lampsYDiagonal.containsKey(i + j)) {
                        lampsYDiagonal.put(i + j, Math.max(0, lampsYDiagonal.get(i + j) - 1));
                    }
                }
            }
        }
    }

    private void initLights(int[][] lamps) {
        for (int[] lamp : lamps) {
            lampsX.put(lamp[0], lampsX.getOrDefault(lamp[0], 0) + 1);
            lampsY.put(lamp[1], lampsY.getOrDefault(lamp[1], 0) + 1);
            lampsXDiagonal.put(lamp[0] - lamp[1], lampsXDiagonal.getOrDefault(lamp[0] - lamp[1], 0) + 1);
            lampsYDiagonal.put(lamp[0] + lamp[1], lampsYDiagonal.getOrDefault(lamp[0] + lamp[1], 0) + 1);
            lampsLoc.add(getLampLoc(lamp[0], lamp[1]));
        }
    }

    private String getLampLoc(int x, int y) {
        return x + "," + y;
    }

    private boolean isLight(int x, int y) {
        return lampsX.getOrDefault(x, 0) > 0
                || lampsY.getOrDefault(y, 0) > 0
                || lampsXDiagonal.getOrDefault(x - y, 0) > 0
                || lampsYDiagonal.getOrDefault(x + y, 0) > 0;
    }
}
