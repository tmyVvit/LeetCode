package Huawei;

public class LastKNode {
    // 删除链表到处第K个节点
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ListNode node1 = arrToList(arr);
        printList(removeLastKNode(node1, 1));
    }

    public static ListNode arrToList(int[] arr) {
        ListNode head = new ListNode();
        ListNode pre = head;
        for (int n : arr) {
            ListNode node = new ListNode(n);
            pre.next = node;
            pre = node;
        }
        return head.next;
    }

    public static void printList(ListNode listNode) {
        ListNode node = listNode;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    public static ListNode removeLastKNode(ListNode head, int k) {
        ListNode curr, currK;
        ListNode p = new ListNode(0, head);
        curr = currK = p;

        while(k-- > 0 && currK.next != null) {
            currK = currK.next;
        }

        if (currK.next == null) return p.next;

        while (currK.next != null) {
            curr = curr.next;
            currK = currK.next;
        }
        curr.next = curr.next.next;
        return p.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
          ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */