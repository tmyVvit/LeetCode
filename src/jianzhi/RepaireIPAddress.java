package jianzhi;

import java.util.ArrayList;
import java.util.List;

public class RepaireIPAddress {
    public List<String> restoreIpAddresses(String s) {
        int[] ips = new int[4];
        List<String> result = new ArrayList<>();
        backtrack(s, 0, ips, 0, result);
        return result;
    }

    private void backtrack(String s, int idx, int[] ips, int ipIdx, List<String> result) {
        if (ipIdx == 4 && idx == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i : ips) {
                if (sb.length() > 0) {
                    sb.append(".");
                }
                sb.append(i);
            }
            result.add(sb.toString());
            return ;
        }

        if (ipIdx < 4 && idx < s.length()) {
            if (s.charAt(idx) == '0') {
                ips[ipIdx] = 0;
                backtrack(s, idx + 1, ips, ipIdx + 1, result);
            } else {
                for (int i = idx + 1; i <= s.length(); i++) {
                    int num = Integer.parseInt(s.substring(idx, i));
                    if (num <= 255) {
                        ips[ipIdx] = num;
                        backtrack(s, i, ips, ipIdx + 1, result);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
