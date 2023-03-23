package Huawei.niuke;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ43FindMazePath {

    private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            int[][] maze = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze[i][j] = sc.nextInt();
                }
            }

            List<int[]> path = findPath(row, col, maze);

            for (int[] p : path) {
                System.out.println("(" + p[0] + "," + p[1] + ")");
            }
        }
    }

    private static List<int[]> findPath(int row, int col, int[][] maze) {
        LinkedList<int[]> stack = new LinkedList<>();
        stack.addLast(new int[]{0, 0});

        boolean res = findPath0(row, col, maze, stack, 0)
                || findPath0(row, col, maze, stack, 1);
        return stack;
    }

    private static boolean findPath0(int row, int col, int[][] maze, LinkedList<int[]> stack, int dir) {
        int[] current = stack.getLast();
        int[] next = new int[]{current[0] + directions[dir][0], current[1] + directions[dir][1]};

        if (stack.size() > 1) {
            int[] pre = stack.get(stack.size() - 2);
            if (next[0] == pre[0] && next[1] == pre[1]) {
                return false;
            }
        }

        if (next[0] < 0 || next[0] >= row || next[1] < 0 || next[1] >= col) {
            return false;
        }

        if (maze[next[0]][next[1]] == 1) {
            return false;
        }

        stack.addLast(next);
        if (next[0] == row - 1 && next[1] == col - 1) {
            return true;
        }

        boolean res = findPath0(row, col, maze, stack, 0)
                || findPath0(row, col, maze, stack, 1)
                || findPath0(row, col, maze, stack, 2)
                || findPath0(row, col, maze, stack, 3);

        if (!res) {
            stack.pollLast();
        }
        return res;
    }
}
