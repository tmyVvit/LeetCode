package validateBinarySearchTree;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);


        Solution s = new Solution();

        System.out.println(s.isValidBST(root));

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Result r = isValidBST0(root);
        return r.isBst;
    }

    public Result isValidBST0(TreeNode node) {
        if (node.left == null && node.right == null) {
            return Result.success(node.val, node.val);
        }

        int max = node.val;
        int min = node.val;
        if (node.left != null) {
            Result leftResult = isValidBST0(node.left);
            if (!leftResult.isBst) {
                return Result.fail();
            }

            if (leftResult.biggest >= node.val) {
                return Result.fail();
            }
            min = leftResult.smallest;
        }

        if (node.right != null) {
            Result rightResult = isValidBST0(node.right);
            if (!rightResult.isBst) {
                return Result.fail();
            }
            if (rightResult.smallest <= node.val) {
                return Result.fail();
            }
            max = rightResult.biggest;
        }
        return Result.success(max, min);
    }

    public static class Result {
        boolean isBst;
        int biggest;
        int smallest;

        public static Result success(int biggest, int smallest) {
            Result result = new Result();
            result.isBst = true;
            result.smallest = smallest;
            result.biggest = biggest;
            return result;
        }

        public static Result fail() {
            return new Result();
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
