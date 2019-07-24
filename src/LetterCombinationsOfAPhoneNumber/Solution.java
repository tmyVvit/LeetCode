// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    //                                    2      3     4       5      6      7      8        9
    private String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> pre = new ArrayList<>();
        if (isEmpty(digits)) return pre;
        digits = preProcess(digits);
        if (digits.length() < 2) return combineTwoString("", getStringByDigit(digits.charAt(0)));
        List<String> tmpResult = new ArrayList<>();
        pre.addAll(combineTwoString("", getStringByDigit(digits.charAt(0))));
        for (int i = 1; i < digits.length(); i++) {
            char tmp = digits.charAt(i);
            for (String str : pre) {
                tmpResult.addAll(combineTwoString(str, getStringByDigit(tmp)));
            }
            pre.clear();
            pre.addAll(tmpResult);
            tmpResult.clear();
        }
        return pre;
    }

    private List<String> combineTwoString(String a, String b) {
        List<String> result = new ArrayList<>();
        if (isEmpty(a) && isEmpty(b)) return result;
        if (isEmpty(b))
            result.add(a);
        else if (isEmpty(a)) {
            for (char str : b.toCharArray()) {
                result.add("" + str);
            }
        } else
            for (int j = 0; j < b.length(); j++) {
                result.add(a + b.charAt(j));
            }

        return result;
    }

    private String getStringByDigit(char digit) {
        int number = Integer.valueOf("" + digit);
        return map[number - 2];
    }

    private boolean isEmpty(String a) {
        return a == null || a.length() == 0;
    }

    private String preProcess(String digits) {
        StringBuilder result = new StringBuilder();
        for (char ch : digits.toCharArray()) {
            int tmp = Integer.valueOf("" + ch);
            if (tmp > 1 && tmp < 10)
                result.append(tmp);
        }
        return result.toString();
    }
}
