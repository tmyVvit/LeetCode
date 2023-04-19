package mianshi202303.pdd;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimitIII {
    private final int limit;
    private final int windowSize;
    private final ConcurrentHashMap<Long, AtomicInteger> windows = new ConcurrentHashMap<>();

    public RateLimitIII(int limit, int windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
    }

    public boolean rateLimit() {
        long current = System.currentTimeMillis() / windowSize;
        AtomicInteger count = windows.computeIfAbsent(current, k -> new AtomicInteger(0));
        boolean res = count.addAndGet(1) < limit;
        windows.entrySet().removeIf(k -> k.getKey() < current);
        return res;
    }

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 3);
        map.put(4, 3);
        map.put(10, 3);

        for (Integer k : map.keySet()) {
            System.out.println(k + ": " + map.get(k));
        }
        System.out.println();
        map.entrySet().removeIf(e -> e.getKey() > 5);
        for (Integer k : map.keySet()) {
            System.out.println(k + ": " + map.get(k));
        }
    }
}
