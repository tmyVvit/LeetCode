package MaximumAverageSubarrayI;

// 643. Maximum Average Subarray I
//Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        int eachK = max;
        for (int i = k; i < length; i++) {
            eachK += nums[i] - nums[i - k];
            max = Math.max(max, eachK);
        }
        return (double) max / k;
    }
}