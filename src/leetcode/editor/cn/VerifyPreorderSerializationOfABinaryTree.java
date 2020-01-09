//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。 
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//  "9,3,4,#,#,1,#,#,#,2,#,6,#,#"
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
// length = n + n - 1
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈


package leetcode.editor.cn;

public class VerifyPreorderSerializationOfABinaryTree{
      public static void main(String[] args) {
          Solution solution = new VerifyPreorderSerializationOfABinaryTree().new Solution();
          System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
      }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0 ) {
            return false;
        }
        if (preorder.equals("#")) {
            return true;
        }
        String[] nums = preorder.split(",");
        MyStack stack = new MyStack(nums.length);
        for (int i = 0; i < nums.length; i++) {
            String str = nums[i];
            if (str.equals("#")) {
                if (stack.isEmpty() || (!stack.isEmpty() && !stack.pop())) {
                    return false;
                }
                continue;
            }
            if ((i !=0 &&stack.isEmpty()) || !stack.push(Integer.parseInt(str))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}

class MyStack {
    Node[] nodes;
    int head;

    public MyStack(int len){
        nodes = new Node[len];
        head = -1;
    }

    public boolean push(int value) {
        if (head == nodes.length - 1) {
            return false;
        }
        Node node = new Node(value);
        nodes[++head] = node;
        return true;
    }

    public boolean pop() {
        if (head < 0) return true;
        Node node = nodes[head];
        if (node.flag == 0) {
            node.flag = 1;
            return true;
        }
        head--;
        return pop();
    }

    public boolean isEmpty() {
        return head == -1;
    }

    class Node {
        int value;
        int flag;

        public Node(int value) {
            this.value = value;
            this.flag = 0;
        }
    }
}