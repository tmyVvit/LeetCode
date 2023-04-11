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

    // 数组中只有一个元素出现一次，其他元素都出现两次
    // 而且数组是有序的，那么对于值出现一次的数字 x
    // x 左边的数字 nums[i] == nums[i+1]，i 是偶数
    // x 右边的数字 num[i] == nums[i+1]，i 是奇数
    public int singleNonDuplicate0(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if ((m & 1) == 0) {
                if (nums[m] == nums[m + 1]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            } else {
                if (nums[m] == nums[m + 1]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        return l;
    }
}
