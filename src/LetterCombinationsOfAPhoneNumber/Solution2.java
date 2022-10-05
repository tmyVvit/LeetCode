package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    //                                          2      3     4      5      6       7       8      9
    private final String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        Solution solution = new Solution();
        int times = 1_000_000;
        System.out.println("solution 1 start: ");
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            solution.letterCombinations("25475");
        }
        long end = System.currentTimeMillis();
        System.out.println("solution 1 end, cost: " + (end - start));

        System.out.println("solution 2 start: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            solution2.letterCombinations("25475");
        }
        end = System.currentTimeMillis();
        System.out.println("solution 2 end, cost: " + (end - start));

    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backtrack(preProcess(digits), 0, new char[digits.length()], result);
        return result;
    }

    private void backtrack(String digits, int index, char[] choose, List<String> result) {
        if (index == digits.length()) {
            result.add(new String(choose));
        } else {
            char cur = digits.charAt(index);
            char[] chars = map[cur - '2'].toCharArray();
            for (char ch : chars) {
                choose[index] = ch;
                backtrack(digits, index + 1, choose, result);
            }
        }
    }

    private String preProcess(String digits) {
        if (digits == null || digits.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (char ch : digits.toCharArray()) {
            if (ch >= '2' && ch <= '9') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
