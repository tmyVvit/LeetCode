package a_day20230829;

import java.util.Arrays;

// https://leetcode.cn/problems/most-profit-assigning-work/description/
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] pd = new int[n][2];
        for (int i = 0; i < n; i++) {
            pd[i][0] = difficulty[i];
            pd[i][1] = profit[i];
        }

        Arrays.sort(pd, (a, b) -> {
            int cd = Integer.compare(a[0], b[0]);
            if (cd != 0) {
                return cd;
            }
            return Integer.compare(b[1], a[1]);
        });

        int maxProfit = -1;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, pd[i][1]);
            pd[i][1] = maxProfit;
        }

        int sum = 0;
        for (int w : worker) {
            int idx = binarySearch(pd, w);
            if (idx >= 0 && idx < n) {
                sum += pd[idx][1];
            }
        }

        return sum;

    }

    private int binarySearch(int[][] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = (r - l + 1) / 2 + l;
            if (arr[m][0] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l >= arr.length || arr[l][0] > target ? l - 1 : l;
    }
}
