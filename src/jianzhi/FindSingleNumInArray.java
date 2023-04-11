package jianzhi;

// 剑指 Offer II 070. 排序数组中只出现一次的数字
// https://leetcode.cn/problems/skFtm2/?favorite=e8X3pBZi
public class FindSingleNumInArray {

    public static void main(String[] args) {
        FindSingleNumInArray s = new FindSingleNumInArray();
        int[] arr = new int[]{3,3,7,7,10,11,11};
        System.out.println(s.singleNonDuplicate(arr));

    }

    public int singleNonDuplicate(int[] nums) {
        int idx = find(nums, 0, nums.length - 1);
        return nums[idx];
    }

    public int find(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        if (l > r || r - l == 1) {
            return -1;
        }

        int m = l + ((r - l) >> 1);
        if (m > l && m < r) {
            if (nums[m - 1] == nums[m]) {
                int res = find(nums, l, m - 2);
                if (res == -1) {
                    return find(nums, m + 1, r);
                }
                return res;
            }
            if (nums[m] == nums[m + 1]) {
                int res = find(nums, l, m - 1);
                if (res == -1) {
                    return find(nums, m + 2, r);
                }
                return res;
            }
            return m;
        }
        return -1;
    }
}
