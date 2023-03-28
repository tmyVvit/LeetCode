package lingxing;

public class QuickSort {
    public static void main(String[] arsg) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{2, 1, 4, 5, 3};
        print(nums);
        quickSort.sort(nums);
        print(nums);

    }

    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }

    public void sort(int[] nums) {
        if (nums != null && nums.length >= 2) {
            sort(nums, 0, nums.length - 1);
        }
    }

    private void sort(int[] nums, int left, int right) {
        if (left == right) {
            return ;
        }
        int middle = partition(nums, left, right);
        sort(nums, left, middle - 1);
        sort(nums, middle + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
       int tmp = nums[left];
       while (left < right) {
           while (right > left && nums[right] > tmp) {
               right--;
           }
           nums[left] = nums[right];
           while (left < right && nums[left] < tmp) {
               left++;
           }
           nums[right] = nums[left];
       }
       nums[left] = tmp;
       return left;

    }
}
