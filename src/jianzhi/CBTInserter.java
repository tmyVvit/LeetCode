package jianzhi;

import java.util.LinkedList;

public class CBTInserter {

    private final Node root;

    private Node last;

    public CBTInserter(TreeNode root) {
        this.root = new Node(root);
        LinkedList<Node> stack = new LinkedList<>();
        last = this.root;
        stack.addLast(this.root);

        while (!stack.isEmpty()) {
            Node node = stack.pollFirst();
            TreeNode treeNode = node.node;

            if (treeNode.left != null) {
                Node left = new Node(treeNode.left);
                stack.addLast(left);
                left.parent = node;
                last.next = left;
                last = left;
            }

            if (treeNode.right != null) {
                Node right = new Node(treeNode.right);
                stack.addLast(right);
                right.parent = node;
                last.next = right;
                last = right;
            }
        }
    }

    public int insert(int v) {
        TreeNode treeNode = new TreeNode(v);
        Node node = new Node(treeNode);

        last.next = node;
        Node parentNode = last.parent;
        if (parentNode == null) {
            parentNode = last;
        }

        if (parentNode.node.left == null) {
            parentNode.node.left = treeNode;
        } else if (parentNode.node.right == null) {
            parentNode.node.right = treeNode;
        } else {
            parentNode = parentNode.next;
            parentNode.node.left = treeNode;
        }

        node.parent = parentNode;
        last = node;
        return parentNode.node.val;
    }

    public TreeNode get_root() {
        return root.node;
    }

    static class Node {
        TreeNode node;
        Node next;
        Node parent;

        Node(TreeNode node) {
            this.node = node;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() { }
        TreeNode(int val) {
            this.val = val;
        }
    }
}
