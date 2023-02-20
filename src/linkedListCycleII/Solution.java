package linkedListCycleII;

public class Solution {

    // 假设链表长 a + b, a 为头到环的入口的长度，b 为环的长度
    // 快慢指针第一次相遇时 分别走的步数是 f 和 s
    // 他们的关系有 f = 2s
    // 同时 f 比 s 多走了 n 个环的长度： f = s + nb
    // --> s = nb, f = 2nb
    // 那么 s 在环中走的步数就是 nb - a，只需要再走 a 步就可以回到环的起点
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean hasCycle(ListNode node) {
        ListNode fast = node, slow = node;
        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        return true;
    }
}
