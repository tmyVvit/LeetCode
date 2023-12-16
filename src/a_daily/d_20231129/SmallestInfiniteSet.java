package a_daily.d_20231129;

import java.util.TreeSet;

public class SmallestInfiniteSet {

    private int limit;

    private final TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        limit = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            return limit++;
        } else {
            return set.pollFirst();
        }
    }

    public void addBack(int num) {
        if (num < limit) {
            set.add(num);
            while (!set.isEmpty() && set.last() == limit - 1) {
                limit--;
                set.pollLast();
            }
        }
    }
}
