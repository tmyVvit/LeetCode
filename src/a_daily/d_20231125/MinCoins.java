package a_daily.d_20231125;

import java.util.Arrays;

public class MinCoins {

    public static void main(String[] args) {
        MinCoins mc = new MinCoins();
//        System.out.println(mc.minimumCoins(new int[]{3, 1, 2}));
        System.out.println(mc.minimumCoins(new int[]{26,18,6,12,49,7,45,45}));
    }

    public int minimumCoins(int[] prices) {
        if (prices.length == 1) {
            return prices[0];
        }
        int len = prices.length;
        int[] dp0 = new int[len];
        int[] dp1 = new int[len];
        Arrays.fill(dp1, Integer.MAX_VALUE);
        Arrays.fill(dp0, Integer.MAX_VALUE);
        dp0[0] = 0;
        dp1[0] = dp0[1] = prices[0];
        for (int i = 1; i < len; i++) {
            int step = i + 1;

            int pre = (i-1)/2;
            int min = dp0[i];
            min = Math.min(min, dp1[pre]);
            dp1[i] = min + prices[i];
            for (int j = 1; j <= step && (i + j) < len; j++) {
                dp0[i+j] = Math.min(dp0[i+j], dp1[i]);
            }
        }

        return Math.min(dp0[len-1], dp1[len-1]);
    }
}
