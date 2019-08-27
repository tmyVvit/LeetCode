package CircularArrayLoop;

import java.util.ArrayList;
import java.util.List;

// 457. Circular Array Loop
//   You are given a circular array nums of positive and negative integers.
//   If a number k at an index is positive, then move forward k steps.
//   Conversely, if it's negative (-k), move backward k steps.
//   Since the array is circular, you may assume that the last element's next element is the first element,
//   and the first element's previous element is the last element.
//
//   Determine if there is a loop (or a cycle) in nums.
//   A cycle must start and end at the same index and the cycle's length > 1.
//   Furthermore, movements in a cycle must all follow a single direction.
//   In other words, a cycle must not consist of both forward and backward movements.


public class Solution {
    private int length;

    public boolean circularArrayLoop(int[] nums) {
        length = nums.length;
        int[] flags = new int[length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (flags[i] == 1 || nums[i] == 0) continue;
            flags[i] = 1;
            int currentIndex = i;
            list.add(currentIndex);
            while (true) {
                int nextIndex = getNextIndex(currentIndex, nums[currentIndex]);
                if (nums[currentIndex] * nums[nextIndex] < 0) {
                    list.clear();
                    break;
                }
                if (list.contains(nextIndex)) {
                    if (list.indexOf(nextIndex) < list.size() - 1) {
                        return true;
                    }
                    list.clear();
                    break;
                }
                currentIndex = nextIndex;
                list.add(currentIndex);
                flags[currentIndex] = 1;
            }
        }
        return false;
    }


    private int getNextIndex(int index, int step) {
        int result = index + step;
        if (result >= length)
            return getNextIndex(0, result - length);
        if (result < 0)
            return getNextIndex(length - 1, result + 1);
        return result;
    }
}
