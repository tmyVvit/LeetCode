package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] i) -> i[0]).thenComparingInt(i -> i[1]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length;) {

            int[] curr = intervals[i];
            int nextIdx = i + 1;

            while (nextIdx < intervals.length && curr[1] >= intervals[nextIdx][0]) {
                if (curr[1] < intervals[nextIdx][1]) {
                    int[] merge = new int[2];
                    merge[0] = curr[0];
                    merge[1] = intervals[nextIdx][1];
                    curr = merge;
                }
                nextIdx++;
            }
            result.add(curr);
            i = nextIdx;
        }
         return result.toArray(new int[0][0]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] i) -> i[0]).thenComparingInt(i -> i[1]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length;) {

            int[] curr = intervals[i];
            int endIdx = i + 1;
            int maxEnd = curr[1];

            while (endIdx < intervals.length && intervals[endIdx][0] <= maxEnd) {
                maxEnd = Math.max(maxEnd, intervals[endIdx][1]);
                endIdx++;
            }
            result.add(new int[]{curr[0], maxEnd});
            i = endIdx;
        }
        return result.toArray(new int[0][0]);
    }

}
