package flattenBinaryTreeToLinkedList;

public class Solution {

    // 将 tree node 展开为一个单链表，展开后的单链表应该同样使用 TreeNode
    // 其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    // 展开后的单链表应该与二叉树 **先序遍历** 顺序相同。
    public void flatten(TreeNode root) {
        doFlatten(root);
    }

    private TreeNode doFlatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        // 展开左子树
        TreeNode left = doFlatten(root.left);
        // 展开右子树
        TreeNode right = doFlatten(root.right);

        // 左子树为空，直接返回
        if (left == null) {
            root.left = null;
            root.right = right;
            return root;
        }

        // 左子树不为空，则拼接
        TreeNode leftDeepest = findDeepest(left);
        root.left = null;
        leftDeepest.right = right;
        root.right = left;
        return root;
    }

    private TreeNode findDeepest(TreeNode root) {
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

}
