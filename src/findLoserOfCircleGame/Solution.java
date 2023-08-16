package findLoserOfCircleGame;

import java.util.ArrayList;
import java.util.List;

// 2682. 找出转圈游戏输家 https://leetcode.cn/problems/find-the-losers-of-the-circular-game/
public class Solution {
    public int[] circularGameLosers(int n, int k) {
        int[] flag = new int[n];
        int s = 0;
        int step = 1;
        flag[s] = 1;
        while (true) {
            s = (s + step * k) % n;
            if (flag[s] == 0) {
                flag[s] = 1;
                step++;
            } else {
                break;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (flag[i] == 0) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
