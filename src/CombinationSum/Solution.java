package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  39. Combination Sum
//   Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
//   find all unique combinations in candidates where the candidate numbers sums to target.
//   The same repeated number may be chosen from candidates unlimited number of times.

//      Note:
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        calculateCombinationSum(results, new ArrayList<>(), candidates, target, 0);
        printList(results);
        return results;
    }

    private void calculateCombinationSum(List<List<Integer>> results, List<Integer> result, int[] candidates, int target, int index) {
        if (target == 0) {
            results.add(result);
            return;
        }
        if (target < 0) return;
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                List<Integer> newResult = new ArrayList<>(result);
                newResult.add(candidates[i]);
                calculateCombinationSum(results, newResult, candidates, target - candidates[i], i);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum(new int[]{2, 3, 7}, 18);
    }

    private void printList(List<List<Integer>> results) {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> result : results) {
            sb.append("[");
            for (Integer integer : result) {
                sb.append(integer).append(", ");
            }
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}
