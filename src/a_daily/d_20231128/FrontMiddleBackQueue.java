package a_daily.d_20231128;

public class FrontMiddleBackQueue {

    public static void main(String[] args) {
        FrontMiddleBackQueue s = new FrontMiddleBackQueue();
        s.pushFront(1);
        s.pushBack(2);
        s.pushMiddle(3);
        s.pushMiddle(4);

        System.out.println(s.popFront());
        System.out.println(s.popMiddle());
        System.out.println(s.popMiddle());
        System.out.println(s.popBack());
        System.out.println(s.popFront());
    }

    private final Node head;
    private final Node tail;
    private Node mid;
    private int size = 0;

    public FrontMiddleBackQueue() {
        head = new Node();
        tail = new Node();
        mid = head;
        head.next = tail;
        tail.pre = head;
    }

    public void pushFront(int val) {
        Node next = head.next;
        Node curr = new Node(val);
        head.next = next.pre = curr;
        curr.next = next;
        curr.pre = head;

        size++;
        if (size == 1) {
            mid = curr;
        } else if ((size & 1) == 0) {
            mid = mid.pre;
        }
    }

    public void pushMiddle(int val) {
        if (size == 0) {
            pushFront(val);
        } else {
            Node node = new Node(val);
            if ((size & 1) == 0) {
                Node next = mid.next;
                mid.next = next.pre = node;
                node.next = next;
                node.pre = mid;
            } else {
                Node pre = mid.pre;
                pre.next = mid.pre = node;
                node.next = mid;
                node.pre = pre;
            }
            mid = node;
            size++;
        }
    }

    public void pushBack(int val) {
        if (size == 0) {
            pushFront(val);
        } else {
            Node cur = new Node(val);
            Node pre = tail.pre;
            pre.next = cur;
            tail.pre = cur;
            cur.next = tail;
            cur.pre = pre;
            size++;
            if ((size & 1) == 1) {
                mid = mid.next;
            }
        }
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        if (size-- == 1) {
            return removeLast();
        } else {
            if ((size & 1) == 1) {
                mid = mid.next;
            }
            Node pop = head.next;
            Node next = pop.next;
            pop.pre = null;
            pop.next = null;
            next.pre = head;
            head.next = next;
            return pop.val;
        }

    }

    private int removeLast() {
        int val = mid.val;
        mid.pre = mid.next = null;
        mid = null;
        head.next = tail;
        tail.pre = head;
        return val;
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        if (size-- == 1) {
            return removeLast();
        } else {
            int val = mid.val;
            Node next = mid.next;
            Node pre = mid.pre;
            mid.pre = mid.next = null;
            pre.next = next;
            next.pre = pre;

            if ((size & 1) == 0) {
                mid = pre;
            } else {
                mid = next;
            }
            return val;
        }

    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        if (size-- == 1) {
            return removeLast();
        } else {
            if ((size & 1) == 0) {
                mid = mid.pre;
            }
            Node node = tail.pre;
            Node pre = node.pre;
            node.next = node.pre = null;
            pre.next = tail;
            tail.pre = pre;
            return node.val;
        }

    }

    static class Node {
        int val;
        Node next;
        Node pre;
        Node() { }
        Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
