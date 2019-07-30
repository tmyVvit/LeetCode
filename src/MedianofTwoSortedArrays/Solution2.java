package MedianofTwoSortedArrays;

// solution 2 , time complexity is O(min(m, n))
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // first set nums1 length less than nums2 length
        if (len1 > len2) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int tmp2 = len2;
            len2 = len1;
            len1 = tmp2;
        }
        int start = 0;
        int end = len1;
        int mid = (len1 + len2 + 1) / 2;
        while (start <= end) {
            int i = (start + end) / 2;
            int j = mid - i;
            if (i < end && nums2[j - 1] > nums1[i]) {
                start = i + 1;
            } else if (i > start && nums1[i - 1] > nums2[j]) {
                end = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((len1 + len2) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == len1) {
                    minRight = nums2[j];
                } else if (j == len2) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
