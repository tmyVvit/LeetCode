package jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, visit, new ArrayList<>(nums.length), res);
        return res;
    }

    private void backtrack(int idx, int[] nums, boolean[] visit, List<Integer> permute, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(permute));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) {
                continue;
            }
            permute.add(nums[i]);
            visit[i] = true;
            backtrack(idx + 1, nums, visit, permute, res);
            visit[i] = false;
            permute.remove(idx);
        }
    }
}
