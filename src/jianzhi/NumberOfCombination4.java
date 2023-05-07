package jianzhi;

public class NumberOfCombination4 {

    public static void main(String[] args) {
        NumberOfCombination4 s = new NumberOfCombination4();
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        System.out.println(s.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            int sum = 0;
            for (int num : nums) {
                int pre = i - num;
                if (pre < 0) {
                    continue;
                }
                sum += dp[pre];
            }
            dp[i] = sum;
        }
        return dp[target];
    }
}
