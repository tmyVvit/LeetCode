package curcularQueue;

// 622. 设计循环队列 https://leetcode.cn/problems/design-circular-queue/description/
class MyCircularQueue {

    private final int[] values;
    private final int len;
    private int head, tail;

    public MyCircularQueue(int k) {
        values = new int[k + 1];
        len = k + 1;
        head = tail = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        values[tail] = value;
        tail = (tail + 1) % len;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % len;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return values[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        // 防止 tail == 0 时为 -1 的情况
        return values[(tail - 1 + len)%len];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return head == ((tail + 1) % len);
    }
}