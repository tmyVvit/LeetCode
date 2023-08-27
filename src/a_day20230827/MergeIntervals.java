package a_day20230827;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] res = new int[n][2];
        int idx = 0;
        res[idx++] = intervals[0];
        for (int i = 1; i < n; i++) {
            int[] cur = intervals[i];
            int[] last = res[idx - 1];
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                res[idx++] = cur;
            }
        }
        return Arrays.copyOf(res, idx);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        MergeIntervals m = new MergeIntervals();
        int[][] res = m.merge(intervals);
        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
