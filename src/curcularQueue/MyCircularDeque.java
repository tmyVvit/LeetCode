package curcularQueue;

// 641. 设计循环双端队列 https://leetcode.cn/problems/design-circular-deque/submissions/
class MyCircularDeque {

    private final int[] values;
    private final int len;
    private int head, tail;


    public MyCircularDeque(int k) {
        values = new int[k + 1];
        len = values.length;
        head = tail = 0;

    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head - 1 + len) % len;
        values[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        values[tail] = value;
        tail = (tail + 1) % len;
        return true;

    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % len;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + len) % len;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return values[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return values[(tail - 1 + len) % len];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return head == (tail + 1) % len;
    }
}
