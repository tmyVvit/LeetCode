package shortestPathToGetAllKeys;

import java.util.*;

public class Solution {

    private static final int[] step = new int[]{0, 1, 0, -1, 0};

    public static void main(String[] args) {
        String[] grid = new String[]{"@fedcbBCDEFaA"};
        String[] grid2 = new String[]{"@.a..","###.#","b.A.B"};
        String[] grid3 = new String[]{"@...a",".###A","b.BCc"};
        /**

         @ . . . a
         . # # # A
         b . B C c

         */
        Solution s = new Solution();
        int res = s.shortestPathAllKeys2(grid3);
        System.out.println(res);
    }

    public int shortestPathAllKeys2(String[] grid) {
        int allKeys = 0, rowCount = grid.length, colCount = grid[0].length();
        int[] startPos = new int[2];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i].charAt(j) == '@') {
                    startPos[0] = i;
                    startPos[1] = j;
                } else if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'z') {
                    allKeys |= 1 << (grid[i].charAt(j) - 'a');
                }
            }
        }
        int[][][] steps = new int[rowCount][colCount][allKeys + 1];
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{startPos[0], startPos[1], 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextRow = curr[0] + step[i];
                int nextCol = curr[1] + step[i + 1];
                if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount) {
                    char ch = grid[nextRow].charAt(nextCol);
                    int currentStep = steps[curr[0]][curr[1]][curr[2]] + 1;
                    if (ch == '.' || ch == '@') {
                        if (steps[nextRow][nextCol][curr[2]] == 0 || steps[nextRow][nextCol][curr[2]] > currentStep) {
                            int[] nextStep = new int[]{nextRow, nextCol, curr[2]};
                            queue.addLast(nextStep);
                            steps[nextRow][nextCol][curr[2]] = currentStep;
                        }
                    } else if (ch >= 'a' && ch <= 'z') {
                        int nextKey = curr[2] | (1 << (ch - 'a'));
                        if (nextKey == allKeys) return currentStep;
                        if (steps[nextRow][nextCol][nextKey] == 0 || steps[nextRow][nextCol][nextKey] > currentStep) {
                            int[] nextStep = new int[]{nextRow, nextCol, nextKey};
                            queue.addLast(nextStep);
                            steps[nextRow][nextCol][nextKey] = currentStep;
                        }
                    } else if (ch >= 'A' && ch <= 'Z') {
                        int needKey = 1 << ((ch - ('A' - 'a')) - 'a');
                        if ((curr[2] & needKey) != 0 && (steps[nextRow][nextCol][curr[2]] == 0 || steps[nextRow][nextCol][curr[2]] > currentStep)) {
                            int[] nextStep = new int[]{nextRow, nextCol, curr[2]};
                            queue.addLast(nextStep);
                            steps[nextRow][nextCol][curr[2]] = currentStep;
                        }
                    }
                }
            }
        }
        return -1;
    }

    // . 空房间
    // # 墙
    // @ 起点
    // 小写字母 钥匙
    // 大写字母 锁
    public int shortestPathAllKeys(String[] grid) {
        int[] start = new int[2];
        Set<String> set = new HashSet<>();
        char[][] chars = new char[grid.length][];
        int allKeys = 0, rows = grid.length, cols = grid[0].length();
        for (int i = 0; i < rows; i++) {
            chars[i] = grid[i].toCharArray();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chars[i][j] == '@') {
                    start[0] = i;
                    start[1] = j;
                } else if (chars[i][j] >= 'a' && chars[i][j] <= 'z') {
                    allKeys |= (1 << (chars[i][j] - 'a'));
                }
            }
        }

        int ans = 0;
        State startState = new State(start[0], start[1], 0);
        set.add(startState.toString());
        List<State> list = new ArrayList<>();
        list.add(startState);

        while (!list.isEmpty()) {
            ans++;
            List<State> next = new ArrayList<>();
            for (State state : list) {
                for (int i = 0; i < 4; i++) {
                    int nextR = state.row + step[i];
                    int nextC = state.col + step[i + 1];
                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && chars[nextR][nextC] != '#') {
                        State nextState = new State(nextR, nextC, state.keys);
                        if (chars[nextR][nextC] == '.' || chars[nextR][nextC] == '@') {
                            if (!set.contains(nextState.toString())) {
                                set.add(nextState.toString());
                                next.add(nextState);
                            }
                        } else if (chars[nextR][nextC] >= 'a' && chars[nextR][nextC] <= 'z'){
                            nextState.keys = nextState.keys | (1 << (chars[nextR][nextC] - 'a'));
                            if (nextState.keys == allKeys) {
                                return ans;
                            }
                            if (!set.contains(nextState.toString())) {
                                set.add(nextState.toString());
                                next.add(nextState);
                            }
                        } else if (chars[nextR][nextC] >= 'A' && chars[nextR][nextC] <= 'Z') {
                            int needKey = 1 << ((chars[nextR][nextC] - ('A' - 'a')) - 'a');
                            if ((nextState.keys & needKey) != 0) {
                                nextState.row = nextR;
                                nextState.col = nextC;
                                if (!set.contains(nextState.toString())) {
                                    set.add(nextState.toString());
                                    next.add(nextState);
                                }
                            }
                        }
                    }
                }
            }
            list = next;
        }

        return -1;
    }

    static class State {
        int row;
        int col;
        int keys;

        State(int r, int c, int k) {
            row = r;
            col = c;
            keys = k;
        }

        public String toString() {
            return String.format("%d.%d.%d", row, col, keys);
        }
    }
}
