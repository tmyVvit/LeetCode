package mianshi202303.alibaba;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    static volatile int printNum = 0;
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> queue = new LinkedList<>();
        Producer p = new Producer(queue);
        Consumer c1 = new Consumer(queue, "B");
        Consumer c2 = new Consumer(queue, "C");
        Consumer c3 = new Consumer(queue, "D");

        Thread threadA = new Thread(p, "threadA");
        Thread threadB = new Thread(c1);
        Thread threadC = new Thread(c2);
        Thread threadD = new Thread(c3);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }


    static class Producer implements Runnable {
        final LinkedList<Integer> queue;
        final Random random;

        Producer(LinkedList<Integer> queue) {
            this.queue = queue;
            this.random = new Random();
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(random.nextInt(190) + 10);
                    synchronized (queue) {
                        if (queue.size() >= 10) {
                            queue.wait();
                        }
                        queue.addLast(i);
                        queue.notifyAll();
                    }
                } catch(Exception e) {}
            }
        }
    }

    static class Consumer implements Runnable {

        final LinkedList<Integer> queue;
        final String name;
        Consumer(LinkedList<Integer> queue, String name) {
            this.queue = queue;
            this.name = name;
        }


        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int num = queue.getFirst();
                    if (num % 2 == 0 && "B".equals(name)) {
                        queue.pollFirst();
                        System.out.println("Thread B: " + num);
                    } else if (num % 3 == 0 && "C".equals(name)) {
                        queue.pollFirst();
                        System.out.println("Thread C: " + num);
                    } else if (num % 2 != 0 && num % 3 != 0 && "D".equals(name)) {
                        queue.pollFirst();
                        System.out.println("Thread D: " + num);
                    }
                    queue.notifyAll();
                    if (num == 100) {
                        break;
                    }
                }
            }
        }
    }

}