package bytedance;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,1};
        System.out.println(new SearchInRotatedSortedArray().search(nums, 1));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else right = mid - 1;
            }
        }
        return -1;
    }
}
