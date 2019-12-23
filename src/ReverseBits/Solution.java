package ReverseBits;

// 190. Reverse Bits
//Reverse bits of a given 32 bits unsigned integer.
//   Input: 00000010100101000001111010011100
//   Output: 00111001011110000010100101000000
//   Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
//                        so return 964176192 which its binary representation is 00111001011110000010100101000000.
public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += ((n >> i) & 1);
        }
        return result;
    }

    // another way to get the reverse.
    public int reverseBits2(int n) {
        int lp = 0X80000000;
        int rp = 0X00000001;
        int count = 0;
        int ret = 0X00000000;
        while (count < 16) {
            int step = 31 - count * 2;
            int l = (lp & n) >>> step;
            int r = (rp & n) << step;
            ret |= l | r;
            lp >>>= 1;
            rp <<= 1;
            count++;
        }
        return ret;
    }
}
