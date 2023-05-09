package multithread;

import java.util.concurrent.Semaphore;

public class GenerateH2O {

    private final Semaphore s1 = new Semaphore(2);
    private final Semaphore s2 = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        s2.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        s1.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        s1.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        s2.release(2);
    }

}
