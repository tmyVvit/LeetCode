package distinctSubsequences2;

import java.util.Arrays;
import java.util.Map;

public class Solution {
    private static final int mod = 1000000007;
    // dp[i] 代表最后一个字符是 ('a' + i) 的子序列的个数
    public int distinctSubseqII(String s) {
        int[] dp = new int[26];
        for (int i = 0; i < 26; i ++) {
            dp[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int val = 1;
            for (int j = 0; j < 26; j++) {
                val += dp[j];
                val %= mod;
            }
            dp[ch - 'a'] = val;
        }
        int total = 0;
        for (int i = 0; i < 26; i ++) {
            total += dp[i];
            total %= mod;
        }
        return total;
    }

    public int distinctSubseqII2(String s) {
        int[] dp = new int[26];
        int total = 0;
        for (int i = 0; i < 26; i ++) {
            dp[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            int pre = dp[idx];
            dp[idx] = (total + 1) % mod;
            total = ((total + dp[idx] - pre) % mod + mod) %mod;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println("abc: " + s.distinctSubseqII("abc"));
//        System.out.println("aab: " + s.distinctSubseqII("aab"));
//        System.out.println("aaa: " + s.distinctSubseqII("aaa"));
//        System.out.println("aba: " + s.distinctSubseqII("aba"));
        System.out.println("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn: " + s.distinctSubseqII2("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn"));
    }
}


/*
a -> a
    dp[0] = 1
a b -> ab b
    dp[1] = 2 = 1 + 1
a b c -> abc ac bc c
    dp[2] = 4 = 1 + 2 + 1

total : 1 + 2 + 4

abaca:
a -> a  -> dp[0] = 1
b -> ab b -> dp[1] = 2
a -> aba aa ba -> dp[2] = 3
c -> ac abc bc abac aac bac c -> dp[2] = 7
a -> aba ba abaa aaa baa aca abca bca abaca aaca baca ca
a b aa ab aab
1 2

a a b
a b aa ab aab

*/
