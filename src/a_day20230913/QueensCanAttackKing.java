package a_day20230913;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/queens-that-can-attack-the-king/
public class QueensCanAttackKing {
    private static final int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] map = new int[8][8];
        for (int[] queen : queens) {
            map[queen[0]][queen[1]] = 1;
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int[] dir : dirs) {
            int i = king[0] + dir[0];
            int j = king[1] + dir[1];
            while (i >= 0 && j >= 0 && i < 8 && j < 8) {
                if (map[i][j] == 1) {
                    result.add(Arrays.asList(i, j));
                    break;
                }

                i += dir[0];
                j += dir[1];
            }
        }

        return result;
    }
}
