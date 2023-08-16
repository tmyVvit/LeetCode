package neighberingBitwiseXor;

// 2683. 相邻值的按位异或 https://leetcode.cn/problems/neighboring-bitwise-xor/
public class Solution {
    public boolean doesValidArrayExist2(int[] derived) {
        if (derived.length == 1) {
            return derived[0] == 0;
        }
        for (int i = 0; i < 2; i++) {
            int x = i;
            for (int d : derived) {
                x ^= d;
            }
            if (x == i) {
                return true;
            }
        }
        return false;
    }

    public boolean doesValidArrayExist1(int[] derived) {
        if (derived.length == 1) {
            return derived[0] == 0;
        }

        int[] origin = new int[derived.length];
        int[][] p1 = new int[][]{{0, 0},{1, 1}};
        int[][] p2 = new int[][]{{0, 1},{1, 0}};

        int[][] p0 = derived[0] == 0 ? p1 : p2;

        for (int[] p : p0) {
            origin[0] = p[0];
            origin[1] = p[1];

            if (valid(derived, origin)) {
                return true;
            }
        }
        return false;
    }

    private boolean valid(int[] derived, int[] origin) {
        int len = derived.length;
        for (int i = 1; i < len - 1; i++) {
            origin[i + 1] = origin[i] ^ derived[i];
        }
        return (origin[0] ^ origin[len - 1]) == derived[len - 1];
    }
}
