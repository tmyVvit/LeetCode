package jianzhi;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        choose(0, nums, tmp, ans);
        return ans;
    }

    private void choose(int i, int[] nums, List<Integer> ans, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(ans));
            return ;
        }

        choose(i + 1, nums, ans, result);
        ans.add(nums[i]);
        choose(i + 1, nums, ans, result);
        ans.remove(ans.size() - 1);
    }

}
