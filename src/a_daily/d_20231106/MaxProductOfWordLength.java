package a_daily.d_20231106;

// https://leetcode.cn/problems/maximum-product-of-word-lengths/?envType=daily-question&envId=2023-11-06
public class MaxProductOfWordLength {

    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            bits[i] = wordToBit(words[i]);
        }
        int max = 0;
        for (int i = 0; i < bits.length; i++) {
            for (int j = i + 1; j < bits.length; j++) {
                if (!hasSameChar(bits[i], bits[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private int wordToBit(String word) {
        int bit = 0;
        for (char c : word.toCharArray()) {
            bit |= 1 << (c - 'a');
        }
        return bit;
    }

    private boolean hasSameChar(int w1, int w2) {
        return (w1 & w2) != 0;
    }

}
