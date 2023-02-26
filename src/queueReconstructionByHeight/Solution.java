package queueReconstructionByHeight;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] p = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        print(s.reconstructQueue(p));
    }

    static void print(int[][] rs) {
        System.out.print("[");
        for (int[] r : rs) {
            System.out.printf("[%d, %d] ", r[0], r[1]);
        }
        System.out.println("]");
    }

    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (int[] a, int[] b) -> {
                    int cmp = a[0] - b[0];
                    if (cmp == 0) {
                        return a[1] - b[1];
                    }
                    return cmp;
                }
        );

        for (int[] p : people) {
            queue.offer(p);
        }
        boolean[] flag = new boolean[people.length];
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int count = 0;
            for (int idx = 0; idx < res.length; idx ++) {

                if (!flag[idx]) {
                    if (count == p[1]) {
                        res[idx] = p;
                        flag[idx] = true;
                        break;
                    } else {
                        count++;
                    }
                }  else {
                    if (res[idx][0] >= p[0]) {
                        count++;
                    }
                }
            }
        }

        return res;
    }
}
