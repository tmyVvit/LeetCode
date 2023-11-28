package a_daily.d_20231124;

import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/?envType=daily-question&envId=2023-11-24
public class CountPairs {

    public static void main(String[] args) {
        CountPairs cp = new CountPairs();
        System.out.println(cp.countPairs(Arrays.asList(-6,2,5,-2,-7,-1,3), -2));
    }

    public int countPairs(List<Integer> nums, int target) {
        int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
        int res = 0;;
        for (int i = 1; i < arr.length; i++) {
            int count = find(arr, i - 1, target - arr[i]);
            res += count;
        }
        return res;
    }


    private int find(int[] arr, int r, int target) {
        int l = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
