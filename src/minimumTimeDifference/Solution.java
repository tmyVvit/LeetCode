package minimumTimeDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMinDifference(Arrays.asList("23:59", "00:00")));

    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        int min = Integer.MAX_VALUE, hour24 = 24 * 60;
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            minutes.add(timeToMinute(time));
        }
        minutes.sort(Integer::compareTo);
        for (int i = 1; i < minutes.size(); i++) {
            int difference = minutes.get(i) - minutes.get(i - 1);
            if (difference == 0) {
                return 0;
            }
            min = Math.min(min, difference);
        }

        min = Math.min(min, minutes.get(0) + hour24 - minutes.get(minutes.size() - 1));
        return min;
    }

    private int timeToMinute(String time) {
        String[] hm = time.split(":");
        int hour = strToNum(hm[0]), minute = strToNum(hm[1]);
        return hour * 60 + minute;
    }

    private int strToNum(String str) {
        int num = 0;
        for (int i = 0; i < 2; i++) {
            int n = str.charAt(i) - '0';
            num = num * 10 + n;
        }
        return num;
    }

}
