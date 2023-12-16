package a_daily.d_20231206;

import java.util.Arrays;

public class FindMaxSmallerNumber {

    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(maxNumber(23121, new int[]{2, 4, 9}));
        System.out.println(maxNumber(20121, new int[]{1, 2, 4, 9}));
    }


    public static int maxNumber(int target, int[] nums) {
        Arrays.sort(nums);
        char[] ches = String.valueOf(target).toCharArray();
        if (dfs(0, ches, nums, false)) {
            return ans;
        }
        return -1;
    }

    private static int ans = 0;

    private static boolean dfs(int i, char[] chs, int[] nums, boolean smaller) {
        if (i >= chs.length) {
            return true;
        }
        if (smaller) {
            ans = ans * 10 + nums[nums.length - 1];
            return dfs(i + 1, chs, nums, smaller);
        } else {
            int ti = chs[i] - '0';
            int idx = findLte(nums, ti);
            int pre = ans;
            while (idx >= 0) {
                smaller = nums[idx] < ti;
                ans = ans * 10 + nums[idx];
                if (dfs(i + 1, chs, nums, smaller)) {
                    return true;
                }
                ans = pre;
                idx--;
            }
        }
        return false;
    }

    // 找到小于等于目标数的最大
    private static int findLte(int[] nums, int t) {
        int l = 0, r = nums.length;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == t) {
                return mid;
            } else if (nums[mid] > t) {
                r--;
            } else {
                l++;
            }
        }
        return r;
    }
}


