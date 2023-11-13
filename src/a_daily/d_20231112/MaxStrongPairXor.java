package a_daily.d_20231112;

import java.util.Arrays;

public class MaxStrongPairXor {

    public static void main(String[] args) {
        MaxStrongPairXor maxStrongPairXor = new MaxStrongPairXor();
        System.out.println(maxStrongPairXor.maximumStrongPairXor(new int[]{1, 1, 3}));
    }
    public int maximumStrongPairXor(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int start = find(nums, i);
            while (start < i) {
                max = Math.max(max, nums[i] ^ nums[start]);
                start++;
            }
        }
        return max;
    }

    int find(int[] nums, int t) {
        int l = 0, r = t - 1;
        int target = (nums[t] + 1) >> 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
