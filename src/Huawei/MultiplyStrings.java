package Huawei;


//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m+n];
        for (int i = m-1; i >=0 ; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n-1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ans[i+j+1] += x*y;
            }
        }
        for (int i = m+n-1; i > 0; i--) {
            ans[i-1] += ans[i]/10;
            ans[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int index = ans[0] == 0 ? 1 : 0;
        while(index < m+n) {
            sb.append(ans[index++]);
        }
        return sb.toString();
    }
}
