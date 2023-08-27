package a_day20230827;

import java.util.Arrays;

// https://leetcode.cn/problems/insert-interval/description/
public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int n = intervals.length;
        int[][] res = new int[n + 1][2];
        int insertIndex = binarySearch(intervals, newInterval);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (insertIndex == i) {
                if (insertOrCombine(res, idx, newInterval)) {
                    idx++;
                }
            }
            int[] cur = intervals[i];
            if (insertOrCombine(res, idx, cur)) {
                idx++;
            }
        }
        if (idx >= n && insertOrCombine(res, idx, newInterval)) {
            idx++;
        }
        return Arrays.copyOf(res, idx);
    }

    // true: insert, false: combine
    private static boolean insertOrCombine(int[][] intervals, int idx, int[] newInterval) {
        if (idx > 0 && newInterval[0] <= intervals[idx - 1][1]) {
            intervals[idx - 1][1] = Math.max(intervals[idx - 1][1], newInterval[1]);
            return false;
        } else {
            intervals[idx] = newInterval;
            return true;
        }
    }

    private static int binarySearch(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] < newInterval[0]) {
                left = mid + 1;
            } else if (intervals[mid][0] > newInterval[0]){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left < 0 || left >= n ? left :
                intervals[left][0] < newInterval[0] ? left + 1 : left;
    }

    private static int binarySearch(int[] array, int find) {
        int n = array.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] < find) {
                l = mid + 1;
            } else if (array[mid] > find) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return l < 0 || l >= n ? l : array[l] < find ? l + 1 : l;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{6, 7};

        int[][] res = insert(intervals, newInterval);
        System.out.println(res);
    }
}
