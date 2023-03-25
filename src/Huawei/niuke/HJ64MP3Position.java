package Huawei.niuke;

import java.util.Scanner;

public class HJ64MP3Position {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            String commands = sc.next();


            int start = 1, end = Math.min(count, 4);
            int current = 1;

            for (int i = 0; i < commands.length(); i++) {
                char command = commands.charAt(i);
                if (command == 'U') {
                    if (current > start) {
                        current--;
                    } else {
                        if (start > 1) {
                            start--;
                            end--;
                            current--;
                        } else {
                            start = Math.max(1, count - 3);
                            end = count;
                            current = count;
                        }
                    }
                } else if (command == 'D') {
                    if (current < end) {
                        current++;
                    } else {
                        if (end < count) {
                            start++;
                            current++;
                            end++;
                        } else {
                            start = 1;
                            current = 1;
                            end = Math.min(count, 4);
                        }
                    }
                }
            }

            for (int i = start; i <= end; i++) {
                System.out.printf("%d ", i);
            }
            System.out.println();
            System.out.println(current);
        }

    }
}
