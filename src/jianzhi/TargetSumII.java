package jianzhi;

import java.util.*;
import java.util.stream.Collectors;

public class TargetSumII {

    public static void main(String[] args) {
        TargetSumII s = new TargetSumII();
        int[] nums = new int[]{2,5,2,1,2};
        List<List<Integer>> res = s.combinationSum2(nums, 5);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : candidates) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer> nums = new ArrayList<>(count.keySet()).stream().sorted().collect(Collectors.toList());

        List<List<Integer>> res = new ArrayList<>();

        choose(0, nums, 0, target, count, new ArrayList<>(), res);
        return res;
    }

    private void choose(int i, List<Integer> nums, int sum, int target, Map<Integer, Integer> count, List<Integer> arr, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(arr));
            return;
        }

        if (i >= nums.size()) {
            return;
        }

        if (sum + nums.get(i) > target) {
            return;
        }

        choose(i + 1, nums, sum, target, count, arr, res);
        int c;
        for (c = 0; c < count.get(nums.get(i)); c++) {
            sum += nums.get(i);
            if (sum > target) {
                break;
            }
            arr.add(nums.get(i));
            choose(i + 1, nums, sum, target, count, arr, res);
        }

        while (c-- > 0) {
            arr.remove(arr.size() - 1);
        }
    }

}
