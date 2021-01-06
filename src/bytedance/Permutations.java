package bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> output = new ArrayList<>();

        boolean[] used = new boolean[nums.length];
        backtrack(used, nums, output, result);
        return result;
    }

    private void backtrack(boolean[] used, int[] nums, List<Integer> output, List<List<Integer>> result) {
        if (output.size() == nums.length) {
            result.add(new ArrayList<>(output));
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]){
                // 标记已经使用
                output.add(nums[i]);
                used[i] = true;
                // 开始选择下一个数组
                backtrack(used, nums, output, result);
                // 回溯
                used[i] = false;
                output.remove(output.size() - 1);
            }
        }
    }
}
