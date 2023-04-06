package convertToBaseNeg2;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(base(3, 2));
        System.out.println(base(2, -2));
        System.out.println(base(3, -2));
        System.out.println(base(4, -2));
        System.out.println(base(-2, -2));
    }

    public String baseNeg2(int n) {
        return base(n, -2);
    }

    public static String base(int num, int base) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int curr = num % base;
            if (curr < 0) {
                curr -= base;
                num += base;
            }
            sb.append(curr);
            num /= base;
        }
        return sb.reverse().toString();
    }
}
