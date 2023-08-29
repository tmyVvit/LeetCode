package a_day20230829;

import java.util.Arrays;

public class FriendsOfAppropriateAges {

    public static void main(String[] args) {
        FriendsOfAppropriateAges f = new FriendsOfAppropriateAges();

        System.out.println(f.numFriendRequests(new int[]{20,30,100,110,120}));
    }

    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        int[] preSum = new int[121];
        for (int i = 1; i <= 120; i++) {
            preSum[i] = preSum[i - 1] + count[i];
        }

        // 0.5*x + 7 < y <= x

        int res = 0;
        for (int i = 15; i <= 120; i++) {
            if (count[i] == 0) {
                continue;
            }
            int left = (int) (0.5 * i + 7);
            int num = preSum[i] - preSum[left] - 1;
            res += num * count[i];
        }
        return res;
    }

}
