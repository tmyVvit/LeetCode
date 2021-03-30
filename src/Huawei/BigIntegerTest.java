package Huawei;

public class BigIntegerTest {
    // 大数相减
    //
    public static void main(String[] args) {
        BigIntegerTest bigIntegerTest = new BigIntegerTest();
        // pre zero
        System.out.println(bigIntegerTest.bigIntegerMinus("1234", "1034"));

        System.out.println(bigIntegerTest.bigIntegerMinus("10000", "1"));

        System.out.println(bigIntegerTest.bigIntegerMinus("123", "123"));

        System.out.println(bigIntegerTest.bigIntegerMinus("1234", "345"));

        System.out.println(bigIntegerTest.bigIntegerMinus("654321", "65432"));

        System.out.println(bigIntegerTest.bigIntegerMinus("654321", "65432"));
    }

    public String bigIntegerMinus(String num1, String num2) {
        // num1 > num2
        int ind1 = num1.length() - 1, ind2 = num2.length() - 1;
        int offset = 0;
        StringBuilder sb = new StringBuilder();
        while (ind1 >= 0 && ind2 >= 0) {
            int n1 = (num1.charAt(ind1) - '0') - offset, n2 = (num2.charAt(ind2) - '0');
            if (n1 >= n2) {
                sb.append(n1 - n2);
                offset = 0;
            } else {
                offset = 1;
                sb.append(n1 - n2 + 10);
            }
            ind1--;ind2--;
        }
        while(ind1 >= 0) {
            int n = num1.charAt(ind1--) - '0';
            if (n - offset >= 0) {
                sb.append(n-offset);
                offset = 0;
            } else {
                sb.append(n-offset + 10);
                offset =1;
            }
        }
        String result = sb.reverse().toString();
        int preZero = 0;
        while (preZero < result.length() && result.charAt(preZero) == '0') {
            preZero++;
        }

        return preZero == result.length() ? "0" : result.substring(preZero);
    }
}
