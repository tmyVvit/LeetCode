package FindDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(final int[] nums) {
        List<Integer> ret = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i] > 0 ? nums[i] : nums[i] * -1;
            nums[tmp - 1] = -1 * tmp;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(nums[i]);
            }
        }
        return ret;
    }
}