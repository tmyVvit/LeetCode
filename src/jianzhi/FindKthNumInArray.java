package jianzhi;

public class FindKthNumInArray {

    public static void main(String[] args) {
        FindKthNumInArray s = new FindKthNumInArray();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(s.findKthLargest(nums, 4));

    }

    public int findKthLargest(int[] nums, int k) {
        return findK(nums, k, 0, nums.length - 1);
    }

    private int findK(int[] nums, int k, int l, int r) {
        int mid = partition(nums, l, r);
        if (mid == nums.length - k) {
            return nums[mid];
        }
        if (mid < nums.length - k) {
            return findK(nums, k, mid + 1, r);
        } else {
            return findK(nums, k, l, mid - 1);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int tmp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= tmp) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= tmp) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }
}

