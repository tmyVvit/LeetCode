package wordSearch;

public class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        char[] chars = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != chars[0]) {
                    continue;
                }

                used[i][j] = true;
                if (find(board, chars, i, j, 1, used)) {
                    return true;
                }
                used[i][j] = false;
            }
        }
        return false;
    }

    private boolean find(char[][] board, char[] word, int i, int j, int idx, boolean[][] used) {
        if (idx == word.length) {
            return true;
        }
        int m = board.length, n = board[0].length;
        // 向右找
        if (j + 1 < n && !used[i][j+1] && board[i][j+1] == word[idx]) {
            used[i][j+1] = true;
            if (find(board, word, i, j + 1, idx + 1, used)) {
                return true;
            }
            used[i][j+1] = false;
        }
        // 向左找
        if (j - 1 >= 0 && !used[i][j-1] && board[i][j-1] == word[idx]) {
            used[i][j-1] = true;
            if (find(board, word, i, j - 1, idx + 1, used)) {
                return true;
            }
            used[i][j-1] = false;
        }
        // 向下找
        if (i + 1 < m && !used[i+1][j] && board[i+1][j] == word[idx]) {
            used[i+1][j] = true;
            if (find(board, word, i + 1, j, idx + 1, used)) {
                return true;
            }
            used[i + 1][j] = false;
        }
        // 向上找
        if (i - 1 >= 0 && !used[i-1][j] && board[i-1][j] == word[idx]) {
            used[i-1][j] = true;
            if (find(board, word, i - 1, j, idx + 1, used)) {
                return true;
            }
            used[i - 1][j] = false;
        }
        return false;
    }
}
