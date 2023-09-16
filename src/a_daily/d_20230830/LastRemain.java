package a_daily.d_20230830;

// 剑指 Offer 62. 圆圈中最后剩下的数字 https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/description/
public class LastRemain {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }

        return ans;
    }

}
