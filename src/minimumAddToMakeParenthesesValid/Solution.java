package minimumAddToMakeParenthesesValid;

public class Solution {
    public int minAddToMakeValid(String s) {
        int leftCount = 0;
        int righCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftCount++;
            } else if (ch == ')') {
                if (leftCount > 0) leftCount--;
                else righCount++;
            }
        }
        return righCount + leftCount;
    }
}
