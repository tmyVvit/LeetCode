package jianzhi;

import java.util.ArrayList;
import java.util.List;

public class TargetSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        choose(0, candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void choose(int i, int[] candidates, int sum, int target, List<Integer> arr, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(arr));
            return ;
        }
        if (i >= candidates.length) {
            return;
        }
        if (sum + candidates[i] <= target) {
            arr.add(candidates[i]);
            choose(i, candidates, sum + candidates[i], target, arr, res);
            arr.remove(arr.size() - 1);
        }
        choose(i + 1, candidates, sum, target, arr, res);
    }
}
