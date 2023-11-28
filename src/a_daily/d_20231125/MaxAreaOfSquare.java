package a_daily.d_20231125;

import java.util.Arrays;

public class MaxAreaOfSquare {

    public static void main(String[] args) {
        MaxAreaOfSquare s = new MaxAreaOfSquare();
        System.out.println(s.maximizeSquareHoleArea(2, 3, new int[]{2, 3}, new int[]{2, 3, 4}));
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hn = 1;
        int hi = 0;
        while (hi < hBars.length) {
            int l = hi + 1;
            while (l < hBars.length && hBars[l]-hBars[l - 1] == 1) {
                l++;
            }
            hn = Math.max(hn, l - hi);
            hi = l;
        }

        int vn = 1;
        int vi = 0;
        while (vi < vBars.length) {
            int l = vi + 1;
            while (l < vBars.length && vBars[l]-vBars[l - 1] == 1) {
                l++;
            }
            vn = Math.max(vn, l - vi);
            vi = l;
        }

        int c = Math.min(vn, hn) + 1;
        return c * c;

    }

}
