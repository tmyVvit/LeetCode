package jianzhi;

import jianzhi.common.TreeNode;

public class BinaryTreeSumNumber {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int pre) {
        if (node == null) {
            return pre;
        }
        pre = pre * 10 + node.val;

        if (node.left == null && node.right == null) {
            return pre;
        }

        int left = 0, right = 0;
        if (node.left != null) {
            left = sumNumbers(node.left, pre);
        }
        if (node.right != null) {
            right = sumNumbers(node.right, pre);
        }
        return left + right;
    }
}
