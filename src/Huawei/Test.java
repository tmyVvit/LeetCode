package Huawei;

import java.math.BigDecimal;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("aaaaaaaaa"));
    }

    public static String removeDuplicates(String S) {
        if (S == null || S.length() < 2) return S;
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
