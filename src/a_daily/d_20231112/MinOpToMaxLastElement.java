package a_daily.d_20231112;

public class MinOpToMaxLastElement {

    public static void main(String[] args) {
        MinOpToMaxLastElement minOpToMaxLastElement = new MinOpToMaxLastElement();
        System.out.println(minOpToMaxLastElement.minOperations(new int[]{1, 2, 7}, new int[]{4, 5, 3}));
    }

    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int last1 = nums1[n - 1], last2 = nums2[n - 1];
        int max1 = 0, max2 = 0;
        for (int i = 0; i < n; i++) {
            max1 = Math.max(max1, nums1[i]);
            max2 = Math.max(max2, nums2[i]);
        }

        if (Math.max(last1, last2) != Math.max(max1, max2)) {
            return -1;
        }

        int swapCount1 = 0;
        int swapCount2 = 1;
        for (int i = 0; i < n - 1; i++) {
            if (Math.min(nums1[i], nums2[i]) > Math.min(last1, last2)) {
                return -1;
            }
            // last 没交换
            if (nums1[i] > last1 || nums2[i] > last2) {
                swapCount1++;
            }
            // last 交换了
            if (nums1[i] > last2 || nums2[i] > last1) {
                swapCount2++;
            }
        }
        return Math.min(swapCount1, swapCount2);
    }
}
