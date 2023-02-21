package houseRobber;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.rob1(new int[]{2,1,1,2}));
        System.out.println(s.rob1(new int[]{1,2,3,1}));
        System.out.println(s.rob1(new int[]{2,7,9,3,1}));

    }

    public int rob(int[] nums) {
        // dp0[i] 表示从 0 -> i 不偷 i 的最大值
        int[] dp0 = new int[nums.length];
        // dp1[i] 表示从 0 -> i 偷 i 的最大值
        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp0[i] = Math.max(dp0[i - 1], dp1[i-1]);
            dp1[i] = dp0[i-1] + nums[i];
        }

        return Math.max(dp0[nums.length - 1], dp1[nums.length - 1]);
    }

    public int rob0(int[] nums) {
        int rob = nums[0], noRob = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmpr = rob, tmpn = noRob;
            noRob = Math.max(tmpr, tmpn);
            rob = nums[i] + tmpn;
        }
        return Math.max(rob, noRob);
    }

    public int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int prepre = i > 1 ? dp[i-2] : 0;
            dp[i] = Math.max(dp[i-1], prepre + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
        int curr = 0, pre = 0;
        for (int i : nums) {
            int tmp = Math.max(curr, pre + i);
            pre = curr;
            curr = tmp;
        }
        return curr;
    }
}
