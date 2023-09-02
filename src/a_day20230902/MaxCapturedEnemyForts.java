package a_day20230902;

// https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/description/?envType=daily-question&envId=2023-09-02
public class MaxCapturedEnemyForts {
    public int captureForts(int[] forts) {
        int l = 0;
        int len = forts.length;
        int max = 0;
        while (l < len) {
            int lv = forts[l];
            if (lv == 0) {
                l++;
                continue;
            }

            int r = l + 1;
            int rv = lv == 1 ? -1 : 1;
            while (r < len && forts[r] == 0) {
                r++;
            }
            if (r < len && forts[r] == rv) {
                max = Math.max(max, r - l - 1);
            }
            l = r;
        }
        return max;
    }
}
