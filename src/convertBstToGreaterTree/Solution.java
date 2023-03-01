package convertBstToGreaterTree;

public class Solution {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST0(TreeNode root) {
//        int total = sum(root);
        return bst(root, 0).node;
    }

    Node bst(TreeNode node, int num) {
        if (node == null) {
            return new Node(null, num);
        }

        TreeNode tn = new TreeNode();
        Node right = bst(node.right, num);
        tn.val = right.max + node.val;
        Node left = bst(node.left, tn.val);
        tn.right = right.node;
        tn.left = left.node;
        return new Node(tn, left.max);
    }

    static class Node {
        TreeNode node;
        int max;

        Node(TreeNode node, int val) {
            this.node = node;
            this.max = val;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode() {}
    }

    int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val
                + sum(node.left)
                + sum(node.right);
    }
}
