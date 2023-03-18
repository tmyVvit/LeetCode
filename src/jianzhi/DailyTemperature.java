package jianzhi;


import java.util.LinkedList;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.getLast()] <= temperatures[i]) {
                stack.pollLast();
            }

            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.getLast() - i;
            }
            stack.addLast(i);
        }
        return res;
    }

}
