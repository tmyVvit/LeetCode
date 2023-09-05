package a_day20230905;

import common.ListNode;

// https://leetcode.cn/problems/next-greater-node-in-linked-list/description/?envType=daily-question&envId=2023-09-05
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        int[] arr = listNodeToArray(head);
        int len = arr.length;
        int[] stack = new int[len];
        int idx = 0;
        stack[0] = arr[len-1];
        arr[len-1] = 0;
        for (int i = len-2; i >= 0; i--) {
            int val = arr[i];
            while (idx >= 0 && val >= stack[idx]) {
                idx--;
            }
            if (idx >= 0) {
                arr[i] = stack[idx];
            } else {
                arr[i] = 0;
            }
            stack[++idx] = val;
        }
        return arr;
    }

    private int[] listNodeToArray(ListNode node) {
        int len = listLen(node);
        int[] result = new int[len];
        ListNode curr = node;
        for (int i = 0; i < len; i++) {
            result[i] = curr.val;
            curr = curr.next;
        }
        return result;
    }

    private int listLen(ListNode node) {
        ListNode curr = node;
        int len = 0;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }
}
