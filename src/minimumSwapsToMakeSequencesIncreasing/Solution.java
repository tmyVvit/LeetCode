package minimumSwapsToMakeSequencesIncreasing;

public class Solution {
    public int minSwap2(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            boolean b1 = nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1];
            boolean b2 = nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1];

            if (b1 && b2) {
                int step = Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][0] = step;
                dp[i][1] = step + 1;
            } else if (b1) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[len-1][0], dp[len-1][1]);
    }

    public int minSwap(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int noChange = 0, change = 1;
        for (int i = 1; i < len; i++) {
            boolean b1 = nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1];
            boolean b2 = nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1];

            if (b1 && b2) {
                int step = Math.min(noChange, change);
                noChange = step;
                change = step + 1;
            } else if (b1) {
                change = change + 1;
            } else {
                int tmp = change;
                change = noChange + 1;
                noChange = tmp;
            }
        }
        return Math.min(noChange, change);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int step = solution.minSwap(new int[]{1,3,5,4}, new int[]{1,2,3,7});
        System.out.println(step);
    }
}
