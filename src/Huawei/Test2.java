package Huawei;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        long value ;
        boolean overFlow = false;
        try (Scanner sc = new Scanner(System.in)) {
            try {
                value = sc.nextLong();
            } catch (InputMismatchException e) {
                value = sc.nextBigDecimal().longValue();
                overFlow = true;
            }
        }
        if (value == 0) {
            System.out.print("00");
            return ;
        }

        if (overFlow) {
            int offset = 0;
            while (offset < 63) {
                int curr = 0;
                for (int i = 0; i < 7; i++, offset ++) {
                    curr += (((value >> i) & 1) << i);
                }
                curr += 8;
                value >>= 7;
                System.out.print(String.format("%02X", curr));
            }
            System.out.print("01");
            return ;
        }

        long copy = value;
        while(copy > 0) {
            int current = 0;
            int i;
            for (i = 0; i < 7 ; i++) {
                current += (((copy >> i) & 1) << i);
            }
            copy = copy >> (i+1);
            if (copy != 0) current += (1 << 7);
            System.out.print(String.format("%02X", current));
            if (copy == 0) break;
        }
    }
}
