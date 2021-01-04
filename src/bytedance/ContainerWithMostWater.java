package bytedance;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        // 双指针
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, area(height, left, right));
            // 左右哪个更小就移动哪一边
            if (height[left] < height[right]) {
                left++;
            } else right--;
        }
        return maxArea;
    }

    private int area(int[] height, int left, int right) {
        return Math.min(height[left], height[right]) *  (right - left);
    }
}
