package a_daily.d_20230831;

import java.util.*;

public class MinimumJumpsToReachHome {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // int len = x + b + 1;
        Set<Integer> forbs = new HashSet<>();
        int maxF = -1;
        for (int f : forbidden) {
            forbs.add(f);
            maxF = Math.max(f, maxF);
        }
        if (x == 0) {
            return forbs.contains(0) ? -1 : 0;
        }


        int len = Math.max(x + b, maxF + a + b) + 1;
        int[][] dp = new int[len][2];


        List<int[]> list0 = new ArrayList<>();
        list0.add(new int[]{0, 0});
        int step = 1;
        while(!list0.isEmpty()) {
            List<int[]> curr0 = list0;
            list0 = new ArrayList<>();

            for (int[] idx : curr0) {
                int next0 = idx[0] + a;
                if (next0 < len && !forbs.contains(next0)) {
                    if (next0 == x) {
                        return step;
                    }

                    if (dp[next0][0] == 0) {
                        dp[next0][0] = step;
                        list0.add(new int[]{next0, 0});
                    }
                }

                if (idx[1] == 0) {
                    int next1 = idx[0] - b;
                    if (next1 > 0 && !forbs.contains(next1)) {
                        if (next1 == x) {
                            return step;
                        }
                        if (dp[next1][0] == 0 && dp[next1][1] == 0) {
                            dp[next1][1] = step;
                            list0.add(new int[]{next1, 1});
                        }

                    }
                }
            }
            step++;
        }
        return -1;
    }
}
