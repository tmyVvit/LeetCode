package bytedance;
/*
给定整数n和k，找到1到n中字典序第k小的数字。
        注意：1 ≤ k ≤ n ≤ 109。
        示例 :
            输入:   n: 13   k: 2
            输出:   10
        解释:
        字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

        字典序，考虑十叉树，计算每个节点的子节点个数，判断是否在第k个树是否在这个节点的子节点里面
        首先想象一个虚的根节点，它的子节点分别是1,2,3,4,...,9
 */
public class FindKthNumberInDictOrder {
    public static void main(String[] args) {
//        681692778
//        351251360
        System.out.println(new FindKthNumberInDictOrder().findKthNumber(681692778, 351251360));
    }
    public int findKthNumber(int n, int k) {
        int curr = 1; // 从第一个子节点开始
        k--; // 去掉第一个
        while (k > 0) {
            int num = getSubNodeNum(n, curr, curr+1);
            if (k >= num) { // 不在当前子树下面
                k -= num;
                curr++;
            } else { // 在这个子树下面
                k--; // 减去当前节点
                curr *= 10; // 根据字典序从上到下
            }
        }
        return curr;
    }
    // 注意参数要是long类型，否则会溢出
    private int getSubNodeNum(int n, long first, long last) {
        int sum = 0;
        while (first <= n) {
            sum += Math.min(n+1, last) - first; // 计算每一层的个数，如果这一层是满的，那么就是last - first，如果不是满的，就是n - first + 1
            first *= 10;
            last *= 10;
        }
        return sum;
    }
}
