package a_day20230828;

import java.util.regex.Pattern;

public class ValidNumber {


    private static final String INTEGER = "[+-]?\\d+";

    private static final String DECIMAL = "[+-]?[\\d*\\.\\d+|\\d+\\.\\d*]";


    private static final String EXPR = "[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?";

    // 使用正则匹配
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty() || ".".equals(s)) {
            return false;
        }
        return s.matches(EXPR);
    }

    public static void main(String[] args) {
        ValidNumber vn = new ValidNumber();

        System.out.println(vn.isNumber("0"));
        System.out.println(vn.isNumber("0.1"));
        System.out.println(vn.isNumber("1.0"));
        System.out.println(vn.isNumber("13e4"));
    }
}
