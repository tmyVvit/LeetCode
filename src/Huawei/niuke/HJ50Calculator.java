package Huawei.niuke;

import java.util.LinkedList;
import java.util.Scanner;

public class HJ50Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(calculate(line));
        }
    }

    public static int calculate(String str) {
        LinkedList<Integer> stack0 = new LinkedList<>();
        LinkedList<Character> stack1 = new LinkedList<>();
        int idx = 0;
        char pre = 0;
        while (idx < str.length()) {
            char ch = str.charAt(idx);
            if (ch == '*' || ch == '/' || ch == '(' || ch == '[' || ch == '{') {
                stack1.addLast(ch);
            } else if(ch == '+') {
                if (stack1.isEmpty() || (stack1.getLast() != '*' && stack1.getLast() != '/')) {
                    stack1.addLast(ch);
                } else {
                    int num1 = stack0.pollLast();
                    int num0 = stack0.pollLast();
                    char f = stack1.pollLast();
                    switch (f) {
                        case '*':
                            stack0.addLast(num0 * num1);
                            break;
                        case '/':
                            stack0.addLast(num0 / num1);
                            break;
                    }
                    stack1.addLast(ch);
                }
            } else if (ch == '-') {
                if (pre >= '0' && pre <= '9') {
                    if (!stack1.isEmpty() && (stack1.getLast() == '*' || stack1.getLast() == '/')) {
                        int num1 = stack0.pollLast();
                        int num0 = stack0.pollLast();
                        char f = stack1.pollLast();
                        switch (f) {
                            case '*':
                                stack0.addLast(num0 * num1);
                                break;
                            case '/':
                                stack0.addLast(num0 / num1);
                                break;
                        }
                    }
                    stack1.addLast(ch);
                } else {
                    char num = str.charAt(++idx);
                    int number = 0;
                    while (num >= '0' && num <= '9') {
                        number = 10 * number + (num - '0');
                        num = str.charAt(++idx);
                    }
                    stack0.addLast(-number);
                    idx--;
                }

            } else if (ch >= '0' && ch <= '9') {
                int number = ch - '0';
                idx++;
                if (idx < str.length()) {
                    ch = str.charAt(idx);
                    while (ch >= '0' && ch <= '9') {
                        number = number * 10 + (ch - '0');

                        idx++;
                        if (idx < str.length()) {
                            ch = str.charAt(++idx);
                        } else break;
                    }
                }

                stack0.addLast(number);
                idx--;
            } else if (ch == ')' || ch == ']' || ch == '}') {
                char end = ch == ')' ? '(' : ch == ']' ? '[' : '{';
                char cal;
                while ((cal = stack1.pollLast()) != end) {
                    int num1 = stack0.pollLast();
                    int num0 = stack0.pollLast();
                    switch (cal) {
                        case '*':
                            stack0.addLast(num0 * num1);
                            break;
                        case '/':
                            stack0.addLast(num0 / num1);
                            break;
                        case '+':
                            stack0.addLast(num0 + num1);
                            break;
                        case '-':
                            stack0.addLast(num0 - num1);
                            break;
                    }
                }
            }
            pre = str.charAt(idx++);
        }

        while (!stack1.isEmpty()) {
            int num0 = stack0.pollFirst();
            int num1 = stack0.pollFirst();
            char cal = stack1.pollFirst();
            switch (cal) {
                case '*':
                    stack0.addFirst(num0 * num1);
                    break;
                case '/':
                    stack0.addFirst(num0 / num1);
                    break;
                case '+':
                    stack0.addFirst(num0 + num1);
                    break;
                case '-':
                    stack0.addFirst(num0 - num1);
                    break;
            }
        }

        return stack0.pollLast();
    }

}
