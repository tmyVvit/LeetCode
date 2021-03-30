package bytedance;

// 小明要在街上一排互相相邻的糖果屋拿糖，但不能在两个相邻的糖果屋拿糖。
// 给定一 个数组列表，每个元素代表每间房子中的糖的数目，
// 小明能看到所有屋的数据，走一遍所有 糖果屋，最多能拿多少糖？
//输入： [1,5,2,1,7] 输出：12
// 输入： [1,5,2,5,7,3] 输出：13
public class GetMostCandy {

    public static void main(String[] args) {
        GetMostCandy mostCandy = new GetMostCandy();
        int[] candies = new int[]{1, 5, 2, 1, 7};
        int[] candies2 = new int[]{1, 5, 2, 5, 7, 3};

        System.out.println(mostCandy.getCandy(candies2));
    }

    public int getCandy(int[] candies) {
        if (candies == null || candies.length == 0) return 0;
        if (candies.length == 1) return candies[0];
        int[] dp = new int[candies.length];
        // dp[i] = max(dp[i-1], dp[i-2] + candies[i])
        dp[0] = candies[0];
        dp[1] = Math.max(candies[0], candies[1]);
        for (int i = 2; i < candies.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + candies[i]);
        }
        return dp[candies.length-1];
    }
}
