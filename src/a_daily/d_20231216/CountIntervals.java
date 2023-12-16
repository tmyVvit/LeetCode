package a_daily.d_20231216;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountIntervals {

    public static void main(String[] args) {
        CountIntervals ci = new CountIntervals();
        ci.add(2, 3);
        ci.add(7, 10);
        System.out.println(ci.count());
        ci.add(5, 8);
        System.out.println(ci.count());

    }

    private final TreeMap<Integer, Integer> intervals = new TreeMap<>();
    private int count;

    public CountIntervals() {

    }

    public void add(int left, int right) {
        for (Map.Entry<Integer, Integer> entry = intervals.ceilingEntry(left); entry != null && entry.getValue() <= right; entry = intervals.ceilingEntry(left)) {
            int l = entry.getValue(), r = entry.getKey();
            count -= (r - l + 1);
            left = Math.min(left, l);
            right = Math.max(right, r);
            intervals.remove(r);
        }

        intervals.put(right, left);
        count += (right - left + 1);
    }

    public int count() {
        return count;
    }
}
