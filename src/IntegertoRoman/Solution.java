package IntegertoRoman;
// 12. Integer to Roman
// Roman numerals are represented by seven different symbols: I, V, X,  L,  C,   D and M.
//                                                            1  5  10 50  100  500   1000
// I can be placed before V (5) and X (10) to make 4 and 9.
// X can be placed before L (50) and C (100) to make 40 and 90.
// C can be placed before D (500) and M (1000) to make 400 and 900.

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<Integer, String> romanMap;

    static {
        romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(5, "V");
        romanMap.put(10, "X");
        romanMap.put(50, "L");
        romanMap.put(100, "C");
        romanMap.put(500, "D");
        romanMap.put(1000, "M");
    }

    public String intToRoman(int num) {
        // 1 <= num <=3999
        int base = 1;
        StringBuilder romanInt = new StringBuilder();
        int copyNum = num;
        while (copyNum > 0) {
            int tmp = copyNum % 10;
            String insertRoman;
            copyNum /= 10;
            if (tmp == 0) {
            } else if (tmp == 9) {
                insertRoman = romanMap.get(base) + romanMap.get(base * 10);
                romanInt.insert(0, insertRoman);
            } else if (tmp >= 5) {
                insertRoman = romanMap.get(5 * base) + getRepeatedString(romanMap.get(base), tmp - 5);
                romanInt.insert(0, insertRoman);
            } else if (tmp == 4) {
                insertRoman = romanMap.get(base) + romanMap.get(5 * base);
                romanInt.insert(0, insertRoman);
            } else {
                insertRoman = getRepeatedString(romanMap.get(base), tmp);
                romanInt.insert(0, insertRoman);
            }
            base *= 10;
        }
        return romanInt.toString();
    }

    private String getRepeatedString(String str, int times) {
        StringBuilder repeatedStr = new StringBuilder();
        for (int i = 0; i < times; i++) {
            repeatedStr.append(str);
        }
        return repeatedStr.toString();
    }
}
