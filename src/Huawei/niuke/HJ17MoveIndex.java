package Huawei.niuke;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HJ17MoveIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        Pattern pattern = Pattern.compile("^[AWSD]\\d{1,2}$");

        String[] strs = line.split(";");
        int x = 0, y = 0;
        for (String s : strs) {
            Matcher m = pattern.matcher(s);
            if (m.matches()) {
                char move = s.charAt(0);
                int steps = Integer.parseInt(s.substring(1));
                switch (move) {
                    case 'A':
                        x -= steps;
                        break;
                    case 'D':
                        x += steps;
                        break;
                    case 'W':
                        y += steps;
                        break;
                    case 'S':
                        y -= steps;
                        break;
                    default:
                }
            }
        }
        System.out.println(x + "," + y);
    }
}
