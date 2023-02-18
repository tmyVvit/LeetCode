package containerWithMostWater;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(s.maxArea2(new int[]{1, 1}));
        System.out.println(s.maxArea2(new int[]{1, 6, 9, 4, 6, 2}));
    }

    public int maxArea(int[] height) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int max = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                left.add(i);
                max = height[i];
            }
        }
        max = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > max) {
                right.add(i);
                max = height[i];
            }
        }

        max = -1;
        for (int l : left) {
            for (int r : right) {
                if (r <= l) {
                    break;
                }
                int h = Math.min(height[l], height[r]);
                max = Math.max(max, h * (r - l));
            }
        }
        return max;
    }

    // 双指针
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            } else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }
}
