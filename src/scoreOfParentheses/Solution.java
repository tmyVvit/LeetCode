package scoreOfParentheses;


public class Solution {

    public int scoreOfParentheses2(String s) {
        int bal = 0, n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                res += 1 << bal;
            }
        }
        return res;
    }

    public int scoreOfParentheses(String s) {
        int[] stack = new int[50];
        int index = -1;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack[++index] = -1;
            } else if (ch == ')') {
                int pre = stack[index--];
                int value = pre;
                if (pre == -1) {
                    value = 1;
                } else {
                    value = 2 * value;
                    index--;
                }

                while (index >= 0 && stack[index] != -1) {
                    value += stack[index--];
                }
                stack[++index] = value;
            }
        }
        return stack[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("() : " + solution.scoreOfParentheses("()"));
        System.out.println("()() : " + solution.scoreOfParentheses("()()"));
        System.out.println("(()) : " + solution.scoreOfParentheses2("(())"));
        System.out.println("(()(())) : " + solution.scoreOfParentheses("(()(()))"));
    }
}
