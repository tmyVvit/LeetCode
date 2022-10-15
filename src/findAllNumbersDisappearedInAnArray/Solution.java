package findAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int num : nums) {
            int v = (num - 1) % n;
            nums[v] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> list1 = s.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(list1);
    }
}
