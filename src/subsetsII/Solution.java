package subsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集II https://leetcode.cn/problems/subsets-ii/
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(s.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        choose(0, nums, list, result);
        return result;
    }

    private void choose(int i, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return ;
        }

        int sameEnd = findSameEnd(i, nums);
        int count = sameEnd - i;
        listAdd(list, nums[i], count);
        while (count >= 0) {
            choose(sameEnd, nums, list, res);
            if (count > 0) {
                list.remove(list.size() - 1);
            }
            count--;
        }
    }

    private int findSameEnd(int start, int[] nums) {
        int end = start;
        while (end < nums.length && nums[start] == nums[end]) {
            end++;
        }
        return end;
    }

    private void listAdd(List<Integer> list, int value, int count) {
        for (int i = 0; i < count; i++) {
            list.add(value);
        }
    }

}
