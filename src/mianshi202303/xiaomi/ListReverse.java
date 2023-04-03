package mianshi202303.xiaomi;

import common.ListNode;

import java.util.Scanner;

public class ListReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int count = sc.nextInt();
            ListNode head = new ListNode();
            ListNode node = head;
            for (int i = 0; i < count; i++) {
                node.next = new ListNode(sc.nextInt());
                node = node.next;
            }
            print(head.next);
            node = reverse0(head.next);
            print(node);
            print(reverse1(node, new ListNode()));
        }
    }

    private static void print(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = node;
        while (cur != null) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.append("null");
        System.out.println(sb);
    }

    public static ListNode reverse0(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }

        ListNode pre = null, cur = listNode, next = listNode.next;

        for (;;) {
            cur.next = pre;
            pre = cur;
            if (next == null) {
                break;
            }
            cur = next;
            next = next.next;
        }
        return pre;
    }

    public static ListNode reverse1(ListNode listNode, ListNode tail) {
        if (listNode == null || listNode.next == null) {
            tail.next = listNode;
            return listNode;
        }

        ListNode node = reverse1(listNode.next, tail);
        if (tail.next != null) {
            tail.next.next = listNode;
            listNode.next = null;
            tail.next = listNode;
        }
        return node;
    }

}
