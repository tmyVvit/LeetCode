package dailyTemperatures;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    // 暴力，超时
    public int[] dailyTemperatures0(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    // 单调栈
    public int[] dailyTemperatures1(int[] temperatures) {
        Deque<Pair> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int nextIdx = 0;
            // 出栈，直到栈为空或者栈顶的温度大于当前温度
            while (!stack.isEmpty() && stack.peekLast().temperature <= temperatures[i]) {
                stack.pollLast();
            }

            // 此时栈要么为空，要么栈里的温度都大于当前温度，并且栈顶到栈底下标时递增的
            if (!stack.isEmpty()) {
                nextIdx = stack.peekLast().idx - i;
            }

            stack.offerLast(new Pair(temperatures[i], i));
            res[i] = nextIdx;
        }
        return res;
    }

    static class Pair {
        int temperature;
        int idx;

        Pair(int temp, int idx) {
            this.temperature = temp;
            this.idx = idx;
        }
    }
}
