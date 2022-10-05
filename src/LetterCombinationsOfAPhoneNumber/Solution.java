// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    //                                          2      3     4       5      6      7      8        9
    private final String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> reslt = solution.letterCombinations("579");
        System.out.println(reslt);
    }

    public List<String> letterCombinations(String digits) {
        List<String> pre = new ArrayList<>();
        if (isEmpty(digits)) return pre;
        digits = preProcess(digits);
        if (digits.length() < 2) return combineTwoString("", getStringByDigit(digits.charAt(0)));
        pre.addAll(combineTwoString("", getStringByDigit(digits.charAt(0))));
        for (int i = 1; i < digits.length(); i++) {
            char tmp = digits.charAt(i);
            List<String> tmpResult = new ArrayList<>();
            for (String str : pre) {
                tmpResult.addAll(combineTwoString(str, getStringByDigit(tmp)));
            }
            pre = tmpResult;
        }
        return pre;
    }

    private List<String> combineTwoString(String a, String b) {
        List<String> result = new ArrayList<>();
        a = isEmpty(a) ? "" : a;
        b = isEmpty(b) ? "" : b;
        for (char ch : b.toCharArray()) {
            result.add(a + ch);
        }

        return result;
    }

    private String getStringByDigit(char digit) {
        int number = Integer.parseInt("" + digit);
        return map[number - 2];
    }

    private boolean isEmpty(String a) {
        return a == null || a.length() == 0;
    }

    private String preProcess(String digits) {
        StringBuilder result = new StringBuilder();
        for (char ch : digits.toCharArray()) {
            if (ch >= '2' && ch <= '9')
                result.append(ch);
        }
        return result.toString();
    }
}
