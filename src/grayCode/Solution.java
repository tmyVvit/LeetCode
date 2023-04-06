package grayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> grayCode0(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(head + ans.get(j));
            }
            head <<= 1;
        }
        return ans;
    }

    public List<Integer> grayCode(int n) {
        int len = 1 << n;
        boolean[] flag = new boolean[len];
        List<Integer> list = new ArrayList<>();
        fill(list, len, n, flag);
        return list;
    }

    private boolean fill(List<Integer> list, int len, int n, boolean[] flag) {
        if (list.size() == len) {
            return isGray(list.get(len - 1), 0);
        }
        int pre = list.get(list.size() - 1);

        for (int i = 0; i < n; i++) {
            int code = grayCode(pre, i);
            if (!flag[code]) {
                flag[code] = true;
                list.add(code);
                if (fill(list, len, n, flag)) {
                    return true;
                }
                list.remove((Integer) code);
                flag[code] = false;
            }
        }
        return false;
    }

    private int grayCode(int num, int i) {
        int m = (num >> i) & 1;
        if (m == 0) {
            return num | (1 << i);
        } else {
            return num & (~(1 << i));
        }
    }

    private boolean isGray(int i, int j) {
        int r = i ^ j;
        int count1 = 0;
        while (r > 0) {
            if ((r & 1) == 1) {
                count1++;
            }
            r >>= 1;
        }
        return count1 == 1;

    }
}
