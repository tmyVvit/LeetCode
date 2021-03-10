package Ali;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AliThread {
    public static void main(String[] args) {
        volatileT();
    }

    private volatile static int flag = 0;
    public static void volatileT() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if (flag % 3 == 0) {
                        System.out.println("A");
                        flag++;
                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if (flag % 3 == 1) {
                        System.out.println("B");
                        flag++;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if (flag % 3 == 2) {
                        System.out.println("C");
                        flag++;
                    }
                }
            }
        }).start();
    }

    public static void threadPool() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        while (true) {
            pool.submit(()-> System.out.println("A"));
            pool.submit(()-> System.out.println("B"));
            pool.submit(()-> System.out.println("C"));
        }
    }
}
