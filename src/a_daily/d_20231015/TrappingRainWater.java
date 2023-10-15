package a_daily.d_20231015;

import java.util.LinkedList;

public class TrappingRainWater {

    // 使用两个数组记录前后缀最大值
    public int trap0(int[] height) {
        int len = height.length;
        int ans = 0;
        int[] preMax = new int[len];
        int[] sufMax = new int[len];

        for (int i = 0; i < len; i++) {
            preMax[i] = i == 0 ? height[i] : Math.max(preMax[i - 1], height[i]);
        }
        for (int i = len - 1; i >= 0; i--) {
            sufMax[i] = (i == len - 1) ? height[i] : Math.max(sufMax[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            int h = Math.min(preMax[i], sufMax[i]);
            ans += (h - height[i]);
        }
        return ans;
    }

    // 使用双指针
    public int trap1(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left++];
            } else {
                ans += rightMax - height[right--];
            }
        }
        return ans;
    }

    // 使用单调栈
    // 前面两个方法都是竖着计算水的容量
    // 这个方法是横着计算的
    public int trap2(int[] height) {
        int len = height.length;
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.addFirst(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peekFirst()]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int left = stack.peekFirst();
                    int curWidth = i - left - 1;
                    int curHeight = Math.min(height[left], height[i]) - height[top];
                    ans += curWidth * curHeight;
                }
                stack.addFirst(i);
            }
        }
        return ans;
    }
}
