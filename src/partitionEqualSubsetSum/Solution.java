package partitionEqualSubsetSum;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(s.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        if (max > target) {
            return false;
        }
        if (max == target) {
            return true;
        }

        // dp[i][j] 代表数组 [0,i] 能否组成和为 j
        boolean[][] dp = new boolean[nums.length][target + 1];
        dp[0][nums[0]] = true;
        dp[0][0] = true;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = true;
            for (int j = 1; j < target + 1; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = true;
                } else if (nums[i] == j){
                    dp[i][j] = true;
                } else if (nums[i] < j){
                    dp[i][j] = dp[i-1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    public boolean canPartition0(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        if (max > target) {
            return false;
        }
        if (max == target) {
            return true;
        }

        // dp[i][j] 代表数组 [0,i] 能否组成和为 j
        boolean[] dp = new boolean[target + 1];
        dp[nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            dp[0] = true;
            for (int j = target; j > 0; j--) {
                if (!dp[j]) {
                    if (nums[i] == j) {
                        dp[j] = true;
                    } else if (nums[i] < j) {
                        dp[j] = dp[j - nums[i]];
                    }
                }
            }
        }
        return dp[target];
    }

}
