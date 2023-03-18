package jianzhi;

import java.util.Deque;
import java.util.LinkedList;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.addLast(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() + asteroid < 0) {
                    stack.pollLast();
                }

                if (stack.isEmpty() || stack.peekLast() < 0) {
                    stack.addLast(asteroid);
                } else if (stack.peekLast() + asteroid == 0) {
                    stack.pollLast();
                }
            }
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pollFirst();
        }
        return res;
    }
}
