package constructBinaryTreeFromPreorderAndInorderTraversal;

import flattenBinaryTreeToLinkedList.TreeNode;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, preorder.length);
    }

//    [3,9,20,15,7]
//    [9,3,15,20,7]
    public TreeNode buildTree(int[] preorder, int s1, int[] inorder, int s2, int count) {
        if (count <= 0) {
            return null;
        }

        int val = preorder[s1];

        TreeNode root = new TreeNode(val);

        if (count == 1) {
            return root;
        }

        int idx = s2;
        for (int i = s2; i < s2 + count; i++) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }
        // left
        TreeNode left = buildTree(preorder, s1 + 1, inorder, s2, idx - s2);
        // right
        TreeNode right = buildTree(preorder, s1 + 1 + idx - s2, inorder, idx + 1, count - 1- idx + s2);
        root.left = left;
        root.right = right;
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
