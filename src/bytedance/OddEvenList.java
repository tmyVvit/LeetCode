package bytedance;

public class OddEvenList {

    public static void main(String[] args) {
        OddEvenList oddEvenList = new OddEvenList();
        int[] nums = {1,2,3,4,5,6,7,8};
        ListNode list = oddEvenList.arrayToList(nums);
        list = oddEvenList.oddEvenList(list);
        oddEvenList.printList(list);
    }

    static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode arrayToList(int[] nums) {
        ListNode head = new ListNode();
        ListNode node = head;
        for (int num : nums) {
            ListNode curr = new ListNode();
            curr.val = num;
            node.next = curr;
            node = curr;
        }
        return head.next;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, node = even.next;
        ListNode evenHead = even;
        boolean isOdd = true;
        while(node != null) {
            if (isOdd) {
                odd.next = node;
                odd = node;
            } else {
                even.next = node;
                even = node;
            }
            isOdd = !isOdd;
            node = node.next;
        }
        odd.next = evenHead;
        return head;
    }

    public void printList(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(" -> ");
            node = node.next;
        }
        sb.append(" null ");
        System.out.println(sb);
    }
}
