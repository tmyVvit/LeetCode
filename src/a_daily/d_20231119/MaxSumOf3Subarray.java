package a_daily.d_20231119;

// https://leetcode.cn/problems/maximum-sum-of-3-non-overlapping-subarrays/?envType=daily-question&envId=2023-11-19
public class MaxSumOf3Subarray {

    public static void main(String[] args) {
        MaxSumOf3Subarray m = new MaxSumOf3Subarray();
        int[] nums = new int[]{1,2,1,2,6,7,5,1};
        int k = 2;
        int[] ans = m.maxSumOfThreeSubarrays(nums, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] presum = new int[nums.length];
        for (int i = 0; i < k; i++) {
            presum[0] += nums[i];
        }
        for (int i = 1; i + k - 1 < nums.length; i++) {
            presum[i] = presum[i-1] - nums[i-1] + nums[i + k - 1];
        }
        int max = 0;
        int[] ans = new int[3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + k; j < nums.length; j++) {
                for (int m = j + k; m + k - 1 < nums.length; m++) {
                    int sum = presum[i] + presum[j] + presum[m];
                    if (sum > max) {
                        ans[0] = i;
                        ans[1] = j;
                        ans[2] = m;
                    }
                }
            }
        }
        return ans;
    }


}
