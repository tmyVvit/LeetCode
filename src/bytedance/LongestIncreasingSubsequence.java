package bytedance;

/**
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS2(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] less = new int[nums.length];
        less[0] = 1;
        int max = 1;
        for (int i = 1; i < less.length; i++) {
            int imax = 1;
            // less[i] = max(less[j]) + 1, 其中需要满足 j < i 且 nums[j] < nums[i]
            for (int j = i - 1; j >= 0 ;j--) {
                if (nums[j] < nums[i]) {
                    imax = Math.max(imax, less[j]+1);
                }
            }
            less[i] = imax;
            max = Math.max(max, less[i]);
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // dp[i] 表示长度为 i 的递增子序列的最小末尾元素的值
        int[] dp = new int[nums.length+1];
        int len = 1;
        dp[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                // 使用二分查找找到pos, dp[pos-1] < nums[i] < dp[pos],然后将dp[pos]值替换为nums[i]
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l+r)>>1;
                    if (dp[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else r = mid - 1;
                }
                dp[pos+1] = nums[i];
            }
        }
        return len;
    }
}
