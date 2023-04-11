package jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergePartition {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int idx = 1, pidx = 0;
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        while (idx < intervals.length) {
            int[] pre = merged.get(pidx);
            int[] curr = intervals[idx];
            if (pre[1] < curr[0]) {
                merged.add(curr);
                pidx++;
            } else {
                pre[1] = Math.max(pre[1], curr[1]);
            }
            idx++;
        }
        return merged.toArray(new int[0][]);
    }
}
