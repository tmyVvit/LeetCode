package jumpGame;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.jumpII2(new int[]{2,3,1,1,4}));
    }

    // 55 - jump game
    // 只要能到达 i，那么任何 j (j < i) 也都是可以到达的
    public boolean jump1(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, nums[i] + i);
        }
        return true;
    }

    // 45 - jump game II
    public int jumpII(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    min = Math.min(min, dp[j] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[dp.length-1];
    }

    public int jumpII2(int[] nums) {
        int step = 0;
        int max = 0;
        int start = 0;
        while (max < nums.length-1) {
            int nextMax = 0;
            for (int i = start; i <= max; i++) {
                int nextPos = nums[i] + i;
                nextMax = Math.max(nextMax, nextPos);
            }
            start = max + 1;
            max = nextMax;
            step++;
        }
        return step;
    }
}
