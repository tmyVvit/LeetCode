package mianshi202303.pdd;

import java.util.concurrent.atomic.AtomicInteger;

public class RateLimit {

    private final int limit;
    private final AtomicInteger count = new AtomicInteger(0);
    private volatile long latestSeconds;

    public RateLimit(int limit) {
        this.limit = limit;
    }

    public boolean rateLimit() {
        long timeNow = System.currentTimeMillis();
        long timeSecond = timeNow / 1000;

        if (timeSecond > latestSeconds) {
            synchronized (this) {
                if (timeSecond > latestSeconds) {
                    latestSeconds = timeSecond;
                }
            }
        }
        if (timeSecond == latestSeconds) {
            int num = count.addAndGet(1);
            return num <= limit;
        }
        return false;
    }
}
