package a_daily.d_20230828;

import common.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        int len = count(head);

        if (len == 0) {
            return head;
        }

        k = k % len;

        if (k == 0) {
            return head;
        }

        int step = len - k;
        ListNode cur = null;
        ListNode ne = head;

        while (step > 0) {
            cur = ne;
            ne = ne.next;
            step--;
        }

        ListNode tail = tail(ne);
        cur.next = null;
        tail.next = head;
        return ne;
    }

    private int count(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + count(head.next);
    }

    private ListNode tail(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        return tail(node.next);
    }
}
