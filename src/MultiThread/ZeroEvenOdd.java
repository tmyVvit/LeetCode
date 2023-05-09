package MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ZeroEvenOdd {
    private final int n;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private volatile int count = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            while (count % 2 != 0) condition.await();
            printNumber.accept(0);
            count++;
            condition.signalAll();
            lock.unlock();
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            while (count % 4 != 3) condition.await();
            printNumber.accept(i);
            count++;
            condition.signalAll();
            lock.unlock();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            while (count % 4 != 1) condition.await();
            printNumber.accept(i);
            count++;
            condition.signalAll();
            lock.unlock();
        }
    }


    static class IntConsumer {

        void accept(int num) {
            System.out.print(num);
        }
    }

    public static void main(String[] args) {

        ZeroEvenOdd c = new ZeroEvenOdd(3);
        IntConsumer consumer = new IntConsumer();
        Thread ta = new Thread(() -> {
            try {
                c.zero(consumer);
            } catch (InterruptedException e) {}
        });
        Thread tb = new Thread(() -> {
            try {
                c.even(consumer);
            } catch (InterruptedException e) {}
        });
        Thread tc = new Thread(() -> {
            try {
                c.odd(consumer);
            } catch (InterruptedException e) {}
        });

        ta.start();
        tb.start();
        tc.start();
    }
}