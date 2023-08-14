package mergeBinaryTree;

import common.TreeNode;

//617. 合并二叉树 https://leetcode.cn/problems/merge-two-binary-trees/description/
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    private TreeNode merge(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        } else if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        } else {
            TreeNode curr = new TreeNode(node1.val + node2.val);
            curr.left = merge(node1.left, node2.left);
            curr.right = merge(node1.right, node2.right);
            return curr;
        }
    }
}
