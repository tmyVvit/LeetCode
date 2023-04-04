package threeSumClosest;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {


            for (int l = i + 1; l < nums.length - 1; l++) {

                int target0 = target - nums[i] - nums[l];
                int r = nums.length - 1;
                while (r > l && nums[r] > target0) {
                    r--;
                }

                if (r < nums.length - 1) {
                    if (Math.abs(nums[r + 1] - target0) < min) {
                        min = Math.abs(nums[r + 1] - target0);
                        sum = nums[r + 1] + nums[l] + nums[i];
                    }
                }

                if (r > l) {
                    if (Math.abs(nums[r] - target0) < min) {
                        min = Math.abs(nums[r] - target0);
                        sum = nums[r] + nums[l] + nums[i];
                    }
                }

                if (sum == target) {
                    return target;
                }

            }



        }
        return sum;

    }

}
