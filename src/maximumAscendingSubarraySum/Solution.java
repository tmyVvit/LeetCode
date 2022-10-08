package maximumAscendingSubarraySum;

public class Solution {
    public int maxAscendingSum(int[] nums) {
        int i = 0, max = 0;
        while (i < nums.length) {
            int j = i, sum = nums[j];
            if (j == nums.length - 1) {
                max = Math.max(sum, max);
                break;
            }
            while (j < nums.length - 1) {
                if (nums[j] < nums[j + 1]) {
                    sum += nums[j+1];
                    if (j == nums.length - 2) {
                        return Math.max(sum, max);
                    }
                    j++;
                } else if (nums[j] > nums[j + 1]) {
                    i = j + 1;
                    break;
                } else if (nums[j] == nums[j + 1]) {
                    i = j + 1;
                    break;
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxAscendingSum(new int[]{100, 10, 1}));
    }
}
