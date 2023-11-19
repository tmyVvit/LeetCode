package a_daily.d_20231114;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadPrintABC {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);


        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    s1.acquire();
                    System.out.print("A");
                    s2.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    s2.acquire();
                    System.out.print("B");
                    s1.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
