package bytedance;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] empty = {};
        int[] nullArr = null;
        int[] oneNum = {1};

        Main main = new Main();
        main.testReverse(nums);
        main.testReverse(empty);
        main.testReverse(nullArr);
        main.testReverse(oneNum);

    }

    void testReverse(int[] arr) {
        Node root = arrayToList(arr);
        Node reverse = reverseList(root);
        printList(reverse);
    }

    void printList(Node root) {
        Node node = root;
        while(node != null) {
            System.out.print(" " + node.value);
            node = node.next;
        }
        System.out.println();
    }

    Node arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node root = new Node(arr[0]);
        Node pre = root;
        for (int i = 1; i < arr.length; i++) {
            Node curr = new Node(arr[i]);
            pre.next = curr;
            pre = curr;
        }
        return root;
    }

    public Node reverseList(Node root) {

        if(root == null || root.next == null) return root;

        Node curr, next, pre;
        pre = null; curr = root; next = root.next;
        while(curr != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
            if (curr != null)
                next = curr.next;
        }
        return pre;
    }

    static class Node {
        int value;
        Node next;
        Node(int val) {
            this.value = val;
        }
    }


}
