package a_daily.d_20230827;

// https://leetcode.cn/problems/permutation-sequence/
public class PermutationSequence {

    private int count = 0;
    private int target;
    public String getPermutation(int n, int k) {
        target = k;
        char[] chars = new char[n];
        boolean[] visited = new boolean[n];
        return reserve(chars, 0, n, visited);
    }

    private String  reserve(char[] chars, int idx, int n, boolean[] visited) {
        if (idx == n) {
            if (++count == target) {
                return new String(chars);
            }
            return "";
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            chars[idx] = getChar(i);
            String res = reserve(chars, idx + 1, n, visited);
            if (!res.isEmpty()) {
                return res;
            }
            visited[i] = false;
        }
        return "";
    }

    private char getChar(int i) {
        return (char) ('0' + (i + 1));
    }

    public static void main(String[] arsg) {
        PermutationSequence p = new PermutationSequence();
        System.out.println(p.getPermutation(3, 3));
    }
}
