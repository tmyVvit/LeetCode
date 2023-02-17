package nextPermutation;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 3};
        s.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(",");
        }
        System.out.println();
    }

    public void nextPermutation(int[] nums) {
        int m = -1, n = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                m = i - 1;
                break;
            }
        }
        if (m == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i > m; i--) {
            if (nums[m] < nums[i]) {
                swap(nums, i, m);
                break;
            }
        }

        reverse(nums, m + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
