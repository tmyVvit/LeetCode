package jianzhi;

import common.ListNode;

public class LinkedListSort {

    public static void main(String[] args) {
        LinkedListSort sort = new LinkedListSort();

        ListNode node0 = new ListNode(5);
        ListNode node = new ListNode(3, node0);
        ListNode node1 = new ListNode(1, node);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(4, node2);

        printList(node3);
        ListNode sorted = sort.sortList(node3);


        printList(sorted);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        ListNode preHead = new ListNode();
        preHead.next = head;
        for (int sub = 1; sub < len; sub <<= 1) {
            ListNode curr, head1, head2, pre = preHead;
            curr = preHead.next;
            while (curr != null) {
                head1 = curr;
                for (int i = 1; i < sub && curr.next != null; i++) {
                    curr = curr.next;
                }
                head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < sub && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }

                if (curr != null) {
                    ListNode tmp = curr.next;
                    curr.next = null;
                    curr = tmp;
                }

                ListNode sorted = merge(head1, head2);
                pre.next = sorted;
                while (sorted.next != null) {
                    sorted = sorted.next;
                }
                pre = sorted;
                pre.next = curr;
            }
        }

        return preHead.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (l1 != null || l2 != null) {
            ListNode node1 = l1;
            ListNode node2 = l2;
            if (node1 == null || (node2 != null && node1.val > node2.val)) {
                tail.next = node2;
                l2 = node2.next;
                node2.next = null;
                tail = node2;
            } else {
                tail.next = node1;
                l1 = node1.next;
                node1.next = null;
                tail = node1;
            }
        }
        return head.next;
    }
}
