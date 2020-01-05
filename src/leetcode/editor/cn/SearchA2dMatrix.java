//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
// 0 [1,   3,  5,  7],
// 1 [10, 11, 16, 20],
// 2 [23, 30, 34, 50],
// 3 [71, 72, 73, 74],
// 4 [91, 92, 93, 94],
//] 1
//target = 13
//输出: false 
// Related Topics 数组 二分查找

package leetcode.editor.cn;

import javax.xml.bind.annotation.XmlID;

public class SearchA2dMatrix {
    public static int[][] matrix = new int[][]{
            new int[]{2, 3, 5, 7},
            new int[]{10, 11, 16, 20},
            new int[]{23, 30, 34, 50},
            new int[]{71, 72, 73, 74},
            new int[]{91, 92, 93, 94},
    };

    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        System.out.println(solution.searchMatrix(matrix, 8));
        System.out.println(solution.searchMatrix(matrix, 5));
        System.out.println(solution.searchMatrix(matrix, 16));
        System.out.println(solution.searchMatrix(matrix, 34));
        System.out.println(solution.searchMatrix(matrix, 80));
        System.out.println(solution.searchMatrix(matrix, 92));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int x = 0, y = 0;
            int mid = 0;
            for (int start = 0, end = m - 1; start <= end; ) {
                mid = (start + end) / 2;
                if (matrix[mid][0] == target) {
                    return true;
                } else if (matrix[mid][0] < target) {
                    start = mid + 1;
                    x = mid;
                } else {
                    end = mid - 1;
                    x = mid - 1;
                }
            }
            if (x < 0) {
                return false;
            }
            for (int start = 0, end = n - 1; start <= end ;) {
                mid = (start + end) / 2;
                if (matrix[x][mid] == target) {
                    return true;
                } else if (matrix[x][mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}