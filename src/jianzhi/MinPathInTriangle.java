package jianzhi;

import java.util.List;

public class MinPathInTriangle {
    // 回溯
    public int minimumTotal0(List<List<Integer>> triangle) {
        return backtrack(0, 0, triangle, 0);
    }

    private int backtrack(int level, int idx, List<List<Integer>> triangle, int sum) {
        if (level >= triangle.size()) {
            return sum;
        }

        int sum0 = backtrack(level + 1, idx, triangle, sum + triangle.get(level).get(idx));
        int sum1 = backtrack(level + 1, idx + 1, triangle, sum + triangle.get(level).get(idx));
        return Math.min(sum0, sum1);
    }

    // dp
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];

        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> current = triangle.get(i);
            int pre = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                int right = j < i ? dp[j] : Integer.MAX_VALUE;
                int tmp = dp[j];
                dp[j] = Math.min(pre, right) + current.get(j);
                pre = tmp;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int n : dp) {
            min = Math.min(min, n);
        }
        return min;
    }
}
