package numbersAtMostNGivenDigitSet;

public class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int len = digits.length;
        int[] nArr = intToArray(n);
        int nlen = nArr.length;
        // 先算位数小于 n 的数的数量
        // count[i] 为组成长度为 i 的数的数量
        // 保存在数组中，后面不用再次计算
        int[] count = beforeN(len, nlen);

        // less[i] 为 digits 中小于 i 的数的个数
        int[] less = new int[11];
        // equals[i] == 1 表示 digits 中存在 i， 否则 equals[i] == 0
        int[] equals = new int[11];

        for (String digit : digits) {
            int currNum = digit.charAt(0) - '0';
            for (int i = currNum + 1; i <= 9; i++) {
                less[i]++;
            }
            equals[currNum] = 1;
        }

        // 再考虑
        // 使用动态规划, dp[i] 表示可组成的小于等于低 i 位的数的数量
        // 例如 n = 321 -> nArr: [1, 2, 3]
        // dp[0] 表示小于 1 的数量， dp[1] 表示小于 21 的数量
        // 当第 i 位选择小于 nArr[i] 时，低于 i 位的数可以任意组合，此时数量： less[nArr[i]] * count[i]
        // 当第 i 位选择等于 nArr[i] 时，低于 i 位的数只能选择小于的组合，此时： equals[nArr[i]] * dp[i - 1]
        // 则可得转移方程：dp[i] = less[nArr[i]] * count[i] + equals[nArr[i]] * dp[i - 1]
        int[] dp = new int[nlen];
        dp[0] = less[nArr[0]] + equals[nArr[0]];
        for (int i = 1; i < nlen; i++) {
            dp[i] = less[nArr[i]] * count[i] + equals[nArr[i]] * dp[i - 1];
        }

        return sum(count) + dp[nlen - 1];
    }

    // 将数字 n 转换为数组 int[i] 表示第 i 位数字
    // e.g. 123 -> [3, 2, 1]
    private int[] intToArray(int n) {
        String nStr = String.valueOf(n);
        int[] num = new int[nStr.length()];
        for (int i = 0; i < nStr.length(); i++) {
            num[nStr.length() - i - 1] = nStr.charAt(i) - '0';
        }
        return num;
    }

    private int sum(int[] count) {
        int sum = 0;
        for (int c : count) {
            sum += c;
        }
        return sum;
    }

    private int[] beforeN(int digitsSize, int nLen) {
        int[] count = new int[nLen + 1];
        for (int i = 1; i < nLen; i++) {
            count[i] =  (int) Math.pow(digitsSize, i);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.atMostNGivenDigitSet(new String[]{"3", "4", "8"}, 4));
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 100));
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1","4","9"}, 1000000000));
        System.out.println(s.atMostNGivenDigitSet(new String[]{"5", "6"}, 19));

    }
}
