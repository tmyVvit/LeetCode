package mianshi202303.pdd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimitII {

    private final int limit;
    private final int windowSize;
    private final AtomicInteger count = new AtomicInteger(0);
    private final AtomicLong latestTime;

    public RateLimitII(int limit, int windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
        this.latestTime = new AtomicLong(System.currentTimeMillis() / windowSize);
    }

    public boolean rateLimit() {
        long currentTime = System.currentTimeMillis() / windowSize;
        long time = latestTime.get();

        for(;;) {
            if (currentTime < time) {
                return false;
            }
            if (currentTime == time) {
                return count.addAndGet(1) < limit;
            } else {
                if (latestTime.compareAndSet(time, currentTime)) {
                    count.set(1);
                    return true;
                } else {
                    Thread.yield();
                    time = latestTime.get();
                }
            }
        }
    }

}
