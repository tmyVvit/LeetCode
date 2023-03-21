package Huawei.niuke;

import java.util.Arrays;
import java.util.Scanner;

public class HJ26StringSort {
    // https://www.nowcoder.com/practice/5190a1db6f4f4ddb92fd9c365c944584?tpId=37&tqId=21249&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line = sc.nextLine();

            Character[] chars = new Character[line.length()];
            int index = 0;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if ((ch >= 'a' && ch <= 'z')
                        || (ch >= 'A' && ch <= 'Z')) {
                    chars[index++] = ch;
                }
            }

            Arrays.sort(chars, 0, index,
                    (c1, c2) -> {
                        int tmp1 = c1 >= 'a' ? c1 - 'a' + 'A' : c1;
                        int tmp2 = c2 >= 'a' ? c2 - 'a' + 'A' : c2;
                        return Integer.compare(tmp1, tmp2);
                    });

            char[] sorted = new char[line.length()];
            index = 0;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if ((ch >= 'a' && ch <= 'z')
                        || (ch >= 'A' && ch <= 'Z')) {
                    sorted[i] = chars[index++];
                } else {
                    sorted[i] = ch;
                }
            }

            System.out.println(new String(sorted));
        }

    }

}
