package robotBoundedInCircle;

public class Solution {

    private final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // 模拟一次移动
    // 只要最终机器人在 原点 或者 方向改变了，那么就存在循环
    // 只有当机器人不在 原点 并且 方向没有改变时，不存在循环
    public boolean isRobotBounded(String instructions) {
        int dir = 0, x = 0, y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char ops = instructions.charAt(i);
            switch (ops) {
                case 'G':
                    x += dirs[dir][0];
                    y += dirs[dir][1];
                    break;
                case 'L':
                case 'R':
                    dir = nextDir(dir, ops);
                    break;
            }
        }

        return (x == 0 && y == 0) || dir != 0;
    }

    private int nextDir(int dir, char ch) {
        if (ch == 'L') {
            return (dir + 4 - 1) % 4;
        }
        if (ch == 'R') {
            return (dir + 1) % 4;
        }
        return dir;
    }
}
