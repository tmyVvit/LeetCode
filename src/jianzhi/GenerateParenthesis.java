package jianzhi;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        char[] parenthesis = new char[2*n];
        List<String> result = new ArrayList<>();
        backtrack(0, n, n, parenthesis, result);
        return result;
    }

    private void backtrack(int idx, int left, int right, char[] parenthesis, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(new String(parenthesis));
            return ;
        }

        if (left > 0) {
            parenthesis[idx] = '(';
            backtrack(idx + 1, left - 1, right, parenthesis, res);
        }
        if (right > 0 && left < right) {
            parenthesis[idx] = ')';
            backtrack(idx + 1, left - 1, right, parenthesis, res);
        }


    }
}
