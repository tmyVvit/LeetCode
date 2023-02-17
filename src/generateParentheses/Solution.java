package generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.generateParenthesis(3);
        System.out.println(res);

    }

    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        char[] chars = new char[2*n];

        place(n, 0, 0, chars, parenthesis);
        return parenthesis;
    }

    public void place(int n, int leftCount, int current, char[] chars, List<String> result) {
        if (current == 2 * n) {
            result.add(new String(chars));
        } else {
            int rightCount = current - leftCount;

            if (leftCount < n) {
                chars[current] = '(';
                place(n, leftCount + 1, current + 1, chars, result);
                if (rightCount < leftCount) {
                    chars[current] = ')';
                    place(n, leftCount, current + 1, chars, result);
                }
            } else if (rightCount < leftCount){
                chars[current] = ')';
                place(n, leftCount, current + 1, chars, result);
            }
        }
    }
}
