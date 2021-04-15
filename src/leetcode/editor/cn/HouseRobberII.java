package leetcode.editor.cn;

// 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
// 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
// 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/house-robber-ii
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int len = nums.length;
        // 由于房屋首尾相连，所以第一个房子和最后一个房子不能同时偷
        // 我们分为两部[0, n-1] 和 [1, n]
        int[] dp1 = new int[len-1];
        int[] dp2 = new int[len-1];
        for (int i = 0; i < len-1; i++) {
            if (i == 0) dp1[i] = nums[i];
            else if (i == 1) dp1[i] = Math.max(nums[0], nums[1]);
            else {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
            }
        }

        for (int i = 0; i < len-1; i++) {
            if (i == 0) dp2[i] = nums[1];
            else if (i == 1) dp2[i] = Math.max(nums[1], nums[2]);
            else {
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i+1]);
            }
        }

        return Math.max(dp1[len-2], dp2[len-2]);
    }
}
