package shortestUnsortedContinuousSubarray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    // 排序
    public int findUnsortedSubarray0(int[] nums) {
        int[] cp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cp);
        int left = 0, right = nums.length - 1;
        while (left < nums.length - 1 && cp[left] == nums[left]) {
            left++;
        }

        while (right >= left && cp[right] == nums[right]) {
            right--;
        }
        return right - left + 1;
    }

    public int findUnsortedSubarray(int[] nums) {
        int left = -1, right = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }

            if (nums[len - i - 1] > min) {
                left = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }

        return right - left + 1;
    }
}
