package Huawei.niuke;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ44Sudoku {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int[][] map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            if(sudoku(map, 0, 0)) {
                print(map);
            } else {
                System.out.println("no result");
            }
        }
    }

    private static void print(int[][] map) {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean sudoku(int[][] map, int r, int c) {
        if (r == -1) {
            return true;
        }

        int[] next = next(r, c);
        if (map[r][c] != 0) {
            if (doCheck(map, r, c)) {
                return sudoku(map, next[0], next[1]);
            } else {
                return false;
            }
        } else {
            Set<Integer> possible = possibleValue(map, r, c);
            for (int val : possible) {
                map[r][c] = val;
                if (sudoku(map, next[0], next[1])) {
                    return true;
                }
                map[r][c] = 0;
            }
        }
        return false;
    }

    private static Set<Integer> possibleValue(int[][] map, int r, int c) {

        Set<Integer> set0 = new HashSet<>();
        set0.add(1);
        set0.add(2);
        set0.add(3);
        set0.add(4);
        set0.add(5);
        set0.add(6);
        set0.add(7);
        set0.add(8);
        set0.add(9);

        for (int i = 0; i < 9; i++) {
            if (map[i][c] != 0) {
                set0.remove(map[i][c]);
            }
            if (map[r][i] != 0) {
                set0.remove(map[r][i]);
            }
        }

        int r0 = r >= 6 ? 6 : r >= 3 ? 3 : 0;
        int c0 = c >= 6 ? 6 : c >= 3 ? 3 : 0;

        for (int i = r0; i < r0 + 3; i++) {
            for (int j = c0; j < c0 + 3; j++) {
                if (map[i][j] != 0) {
                    set0.remove(map[i][j]);
                }
            }
        }

        return set0;
    }

    private static boolean doCheck(int[][] map, int r, int c) {
        if (c == 8 && !checkRow(map, r)) {
            return false;
        }
        if (r == 8 && !checkCol(map, c)) {
            return false;
        }
        if ((r == 2 || r == 5 || r == 8) && (c == 2 || c == 5 || c == 8) && !checkChunk(map, r, c)) {
            return false;
        }
        return true;
    }

    private static boolean checkChunk(int[][] map, int r, int c) {
        int[] check = new int[9];
        for (int r0 = r - 2; r0 <= r; r0++) {
            for (int c0 = c - 2; c0 <= c; c0++) {
                if (map[r0][c0] == 0) {
                    return false;
                }
                if(check[map[r0][c0] - 1] != 0) {
                    return false;
                }
                check[map[r0][c0] - 1] = 1;
            }
        }
        return true;
    }

    private static boolean checkCol(int[][] map, int c) {
        int[] check = new int[9];
        for (int i = 0; i < 9; i++) {
            if (map[i][c] == 0) {
                return false;
            }
            if (check[map[i][c] - 1] != 0) {
                return false;
            }
            check[map[i][c] - 1] = 1;
        }
        return true;
    }

    private static boolean checkRow(int[][] map, int r) {
        int[] check = new int[9];
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == 0) {
                return false;
            }
            if (check[map[r][i] - 1] != 0) {
                return false;
            }
            check[map[r][i] - 1] = 1;
        }
        return true;
    }

    private static int[] next(int r, int c) {
        if (c < 8) {
            return new int[]{r, c + 1};
        }
        if (r < 8) {
            return new int[]{r + 1, 0};
        }
        return new int[]{-1, -1};
    }
}
