package minStack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    private final Deque<Integer> stack = new LinkedList<>();
    private final Deque<Integer> minStack = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            int min = Math.min(minStack.peek(), val);
            minStack.push(min);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
