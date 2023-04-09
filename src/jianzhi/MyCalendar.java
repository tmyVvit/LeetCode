package jianzhi;


import java.util.TreeSet;

public class MyCalendar {

    private final TreeSet<int[]> set;

    public MyCalendar() {
        set = new TreeSet<>((a, b) -> {
           if (a[0] >= b[1]) {
               return 1;
           }
           if (a[1] <= b[0]) {
               return -1;
           }
           // 如果有交集，则相等
           return 0;
        });
    }

    // [start, end)
    public boolean book(int start, int end) {
        // 相等时（有交集）会插入失败
        return set.add(new int[]{start, end});
    }
}
