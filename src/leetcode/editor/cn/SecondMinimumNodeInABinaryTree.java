//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 示例 1: 
//
// 
//输入: 
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//输出: 5
//说明: 最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2: 
//
// 
//输入: 
//    2
//   / \
//  2   2
//
//输出: -1
//说明: 最小的值是 2, 但是不存在第二小的值。
// 
// Related Topics 树
package leetcode.editor.cn;

public class SecondMinimumNodeInABinaryTree{
      public static void main(String[] args) {
           Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
      }


//      Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || isLeaf(root)) return -1;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left.val != root.val && root.val != right.val) {
            return Math.min(left.val, right.val);
        } else if (left.val == root.val && left.val != right.val) {
            int secondLeft = findSecondMinimumValue(left);
            return secondLeft == -1 ? right.val : Math.min(secondLeft, right.val);
        } else if (right.val != left.val) {
            int secondRight = findSecondMinimumValue(right);
            return secondRight == -1 ? left.val : Math.min(secondRight, left.val);
        }

        if (isLeaf(left) && isLeaf(right)) {
            return -1;
        }
        int secondLeft = findSecondMinimumValue(left);
        int secondRight = findSecondMinimumValue(right);
        if (isLeaf(left)) {
            return secondRight;
        }
        if (isLeaf(right)) {
            return secondLeft;
        }
        return secondLeft == -1 ? secondRight
                    : (secondRight == -1 ? secondLeft : Math.min(secondLeft, secondRight));
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}