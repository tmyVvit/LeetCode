package swapAdjacentInLrString;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

    public boolean canTransform(String start, String end) {
        int i = 0, j = 0, len = start.length();
        while (true) {
            while (i < len && start.charAt(i) == 'X') {
                i++;
            }
            while (j < len && end.charAt(j) == 'X') {
                j++;
            }
            if (i == len && j == len) return true;
            if (i ==len || j == len) return false;
            if (start.charAt(i) == end.charAt(j)) {
                if (start.charAt(i) == 'L' && i < j) return false;
                if (start.charAt(i) == 'R' && i > j) return false;
            } else {
                return false;
            }
            i++;
            j++;
        }
    }

}
