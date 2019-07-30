package MedianofTwoSortedArrays;

// 4. Median of Two Sorted Arrays
// There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
// You may assume nums1 and nums2 cannot be both empty.

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return findMedian(nums2);
        }
        if (nums2 == null) {
            return findMedian(nums1);
        }
        int[] nums = combineSortedArrays(nums1, nums2);
        return findMedian(nums);

    }

    private double findMedian(int[] nums) {
        int length = nums.length;
        return (nums[length / 2] + nums[(length - 1) / 2]) / 2.0;
    }

    private int[] combineSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i, j, k;
        i = j = k = 0;
        while (k < nums.length) {
            if (i == nums1.length) {
                nums[k++] = nums2[j++];
            } else if (j == nums2.length) {
                nums[k++] = nums1[i++];
            } else {
                if (nums1[i] < nums2[j]) {
                    nums[k++] = nums1[i++];
                } else {
                    nums[k++] = nums2[j++];
                }
            }

        }
        return nums;
    }
}
