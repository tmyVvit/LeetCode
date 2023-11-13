package a_daily.d_20231114;

// https://leetcode.cn/problems/range-sum-query-mutable/?envType=daily-question&envId=2023-11-13
public class NumArray {
    private final int[] nums;
    private final int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length + 1];

        for (int i = 1; i < tree.length; i++) {
            tree[i] = nums[i - 1];
            int j = i + lowbit(i);
            if (j < tree.length) {
                tree[j] += tree[i];
            }
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        for (int i = index + 1; i < tree.length; i += lowbit(i)) {
            tree[i] += diff;
        }
    }

    public int sumRange(int left, int right) {
        return presum(right + 1) - presum(left);
    }

    private int presum(int i) {
        int s = 0;
        while (i > 0) {
            s += tree[i];
            i -= lowbit(i);
        }
        return s;
    }

    private int lowbit(int i) {
        return i & (-i);
    }
}
