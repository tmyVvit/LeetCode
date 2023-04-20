package jianzhi;

import java.util.*;

public class LongestFibonacci {

    public static void main(String[] args) {
        int[] ar = new int[]{1,2,3,6,7,8,9,10,12,14,21,33};
        System.out.println(lenLongestFibSubseq(ar));
    }

    public static int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer>[] dp = new Map[arr.length];
        int max = 0;
        for (int i = 2; i < arr.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = i - 1; j > 1; j--) {

                if (dp[j] != null) {
                    for (int pre : dp[j].keySet()) {
                        if (arr[j] + pre == arr[i]) {
                            dp[i].put(arr[j], dp[j].get(pre) + 1);
                            max = Math.max(dp[i].get(arr[j]), max);
                        }
                    }
                }
            }

            int l = 0, r = i - 1;
            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum == arr[i]) {
                    if (!dp[i].containsKey(arr[r])) {
                        dp[i].put(arr[r], 3);
                        max = Math.max(max, 3);
                    }
                    l++;
                    r--;
                } else if (sum < arr[i]) {
                    l++;
                } else r--;
            }

        }
        return max;
    }

}
