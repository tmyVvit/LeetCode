package maximumProductSubarray;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxProduct(new int[]{2,-5,-2,-4,3}));
        System.out.println(s.maxProduct0(new int[]{2,-5,-2,-4,3}));
    }

    public int maxProduct(int[] nums) {

        int min0 = nums[0], max0 = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmin = min0, tmax = max0;
            max0 = Math.max(tmax * nums[i], Math.max(nums[i], tmin * nums[i]));
            min0 = Math.min(tmax * nums[i], Math.min(nums[i], tmin * nums[i]));
            max = Math.max(max, max0);
        }
        return max;
    }

    public int maxProduct0(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int max0 = max[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i-1] * nums[i], min[i-1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(min[i-1] * nums[i], max[i-1] * nums[i]));

            max0 = Math.max(max[i], max0);
        }
        return max0;
    }
}
