package a_daily.d_20231106;

// https://leetcode.cn/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/
public class MinSumOfTwoArray {
    public long minSum(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        int left1 = 0, left2 = 0;
        for (int n : nums1) {
            sum1 += n;
            if (n == 0) {
                left1++;
            }
        }
        for (int n : nums2) {
            sum2 += n;
            if (n == 0) {
                left2++;
            }
        }

        if (left1 == 0 && left2 == 0) {
            return sum1 == sum2 ? sum1 : -1;
        } else if (left1 == 0) {
            if (sum1 >= sum2 + left2) {
                return sum1;
            }
            return -1;
        } else if (left2 == 0) {
            if (sum2 >= sum1 + left1) {
                return sum2;
            }
            return -1;
        } else {
            return Math.max(sum2 + left2, sum1 + left1);
        }
    }
}
