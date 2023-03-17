package jianzhi;

import java.util.Deque;
import java.util.LinkedList;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for (String token : tokens) {
            if ("*".equals(token)) {
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                stack.addLast(num1 * num2);
            } else if ("/".equals(token)) {
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                stack.addLast(num2 / num1);
            } else if ("+".equals(token)) {
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                stack.addLast(num2 + num1);
            } else if ("-".equals(token)) {
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                stack.addLast(num2 - num1);
            } else {
                stack.addLast(Integer.valueOf(token));
            }
        }
        return stack.pollLast();
    }
}
