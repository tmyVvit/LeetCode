package linkedListComponents;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numComponents(ListNode head, int[] nums) {
        if (head == null) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        ListNode curr = head;
        while (!set.isEmpty() && curr != null) {
            if (set.remove(curr.val)) {
                count++;
                curr = curr.next;
                while (curr != null && set.remove(curr.val)) {
                    curr = curr.next;
                }
            }
            if (curr != null) {
                curr = curr.next;
            }
        }
        return count;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
