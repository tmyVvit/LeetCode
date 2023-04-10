package mianshi202303.zijie;

public class TestII {

    public static void main(String[] args) {
        TestII t = new TestII();

        int[] nums = new int[]{1, 2, 3, 3, 4, 5, 6};

        print(t.findRange(nums, 3));
        print(t.findRange(nums, 1));
        print(t.findRange(nums, -1));
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    // 从一个升序排列的数组中找到给定值 target 的范围
    // nums: [3,4,5,8,8,8,10], target: 8 --> 返回 [3, 5]
    // 如果不存在的话就返回 [-1, -1]

    public int[] findRange(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int l = findLeft(nums, target, 0, nums.length - 1);
        int r = findRight(nums, target, 0, nums.length - 1);
        return new int[]{l, r};
    }

    public int findLeft(int[] nums, int target, int l, int r) {
        if (l == r) {
            return nums[l] == target ? l : l + 1;
        }
        int m = (l + r + 1) / 2;
        if (nums[m] >= target) {
            return findLeft(nums, target, l, m - 1);
        }
        return findLeft(nums, target, m + 1, r);
    }

    public int findRight(int[] nums, int target, int l, int r) {
        if (l == r) {
            return nums[l] == target ? l : l - 1;
        }
        int m = (l + r) / 2;
        if (nums[m] > target) {
            return findRight(nums, target, l, m - 1);
        }
        return findRight(nums, target, m + 1, r);
    }

}
