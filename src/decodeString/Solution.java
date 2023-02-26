package decodeString;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.decodeString2("3[a]2[bc]"));
//        System.out.println(s.decodeString2("2[a2[c]2[d]]"));
//        System.out.println(s.decodeString2("a2[b2[c]2[d]]"));
        System.out.println(s.decodeString2("abc3[cd]xyz"));
    }


    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public String decodeString2(String s) {
        Deque<String> stack = new LinkedList<>();
        Deque<Integer> number = new LinkedList<>();
        int idx = 0;
        while (idx < s.length()) {
            if (isLetter(s.charAt(idx))) {
                int start = idx;
                while (idx < s.length() && isLetter(s.charAt(idx))) {
                    idx++;
                }
                stack.push(s.substring(start, idx));
            } else if (isNumber(s.charAt(idx))) {
                int count = 0;
                while (idx < s.length() && isNumber(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                number.push(count);
            } else if (s.charAt(idx) == ']') {
                StringBuilder sb = new StringBuilder();
                List<String> list = new ArrayList<>();
                while (!"[".equals(stack.peek())) {
                    list.add(stack.pop());
                }
                for (int i = list.size() - 1; i >= 0; i--) {
                    sb.append(list.get(i));
                }
                StringBuilder nsb = new StringBuilder();
                repeat(sb.toString(), number.pop(), nsb);
                stack.pop();
                stack.push(nsb.toString());
                idx++;
            } else if (s.charAt(idx) == '[') {
                stack.push("[");
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    private void repeat(String s, int time, StringBuilder sb) {
        for (int i = 0; i < time; i++) {
            sb.append(s);
        }
    }

}
