package a_daily.d_20231201;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletePainColOrRow {

    public static void main(String[] args) {
        FirstCompletePainColOrRow s = new FirstCompletePainColOrRow();
        int[] arr = new int[]{1,4,5,2,6,3};
        int[][] mat = new int[][]{{4,3,5},{1,2,6}};
        System.out.println(s.firstCompleteIndex(arr, mat));
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> numToCol = new HashMap<>();
        Map<Integer, Integer> numToRow = new HashMap<>();

        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = mat[i][j];
                numToCol.put(num, j);
                numToRow.put(num, i);
            }
        }

        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int r = numToRow.get(arr[i]);
            int c = numToCol.get(arr[i]);

            rows[r]++;
            cols[c]++;
            if (rows[r] >= n || cols[c] >= m) {
                return i;
            }
        }
        return -1;
    }
}
