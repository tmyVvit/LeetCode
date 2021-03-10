package Ali;

import javax.xml.stream.events.StartDocument;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAli {
    private static Lock lock = new ReentrantLock();
    private int state;
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    public static void main(String[] args) {
        PrintAli printAli = new PrintAli();
        new Thread(() -> {
            printAli.print("A", 0, c1, c2);
        }).start();
        new Thread(() -> {
            printAli.print("B", 1, c2, c3);
        }).start();
        new Thread(() -> {
            printAli.print("C", 2, c3, c1);
        }).start();
    }

    public void print(String name, int target, Condition curr, Condition next) {
        while (true) {
            lock.lock();
            try {
                while (state % 3 != target) {
                    curr.await();
                }
                state++;
                System.out.println(name);
                next.signal();
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void print(String name, int target) {
        while (true) {
            lock.lock();
            try {
                while (state % 3 != target) {
                }
            }catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }
}
