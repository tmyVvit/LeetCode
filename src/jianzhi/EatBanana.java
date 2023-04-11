package jianzhi;

// 剑指 Offer II 073. 狒狒吃香蕉
// https://leetcode.cn/problems/nZZqjQ/?favorite=e8X3pBZi
public class EatBanana {

    public static void main(String[] args) {
        EatBanana e = new EatBanana();
        int[] piles = new int[]{3,6,7,11};
        System.out.println(e.minEatingSpeed(piles, 8));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        while (l < r) {
            int m = l + ((r - l) >> 1);
            int mh = eatHour(piles, m);
            if (mh > h) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int eatHour(int[] piles, int k) {
        int h = 0;
        for (int pile : piles) {
            int tmp = pile / k;
            if (pile % k != 0) {
                tmp += 1;
            }
            h += tmp;
        }
        return h;
    }
}
