package bytedance;


/**
 * 215. Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,5,4};
        System.out.println(new FindKthLargest().findKthLargest(nums, 4));
    }

    // 使用最大堆来解决
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return -1;
        // 建堆
        buildHeap(nums);

        for (int i = 0; i < k-1; i++) {
            deleteHeap(nums, nums.length - i);
        }
        return nums[0];
    }

    private void deleteHeap(int[] nums, int size) {
        // 将堆顶和堆中最后一个元素交换
        swap(nums, 0, size-1);
        modify(nums, 0, size-1);
    }

    private void buildHeap(int[] nums) {
        int nonLeaf = (nums.length - 1) / 2;
        for (int i = nonLeaf; i >= 0; i--) {
            modify(nums, i, nums.length);
        }
    }

    private void modify(int[] nums, int nonLeaf, int size) {
        int left = nonLeaf * 2 + 1, right = nonLeaf * 2 + 2,  largest = nonLeaf;
        if (left < size && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < size && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != nonLeaf) {
            swap(nums, nonLeaf, largest);
            modify(nums, largest, size);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
