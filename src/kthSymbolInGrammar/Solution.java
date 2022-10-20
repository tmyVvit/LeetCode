package kthSymbolInGrammar;

public class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int m = 1 << (n - 2);
        if (k <= m) return kthGrammar(n - 1, k);
        else return 1 - kthGrammar(n - 1, k - m);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.kthGrammar(2, 2));
    }
}


