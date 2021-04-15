package leetcode.editor.cn;

// 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
//  给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/house-robber
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) dp[i] = nums[i];
            else if (i == 1) dp[i] = Math.max(nums[0], nums[1]);
            else dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[dp.length-1];
    }
}
