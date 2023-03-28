package Huawei.niuke;

import java.util.*;

public class HJ19RecordError {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        Map<String, Integer> set = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();

        while (in.hasNext()) { // 注意 while 处理多个 case
            String[] line = in.nextLine().split(" ");
            String path = line[0];
            int lineNum = Integer.parseInt(line[1]);
            String filename = fileName(path);

            String format = filename + " " + lineNum;
            if (!set.containsKey(format)) {
                set.put(format, 1);
                if (list.size() < 8) {
                    list.addLast(format);
                } else {
                    list.pollFirst();
                    list.addLast(format);
                }
            } else {
                set.put(format, set.get(format) + 1);
            }
        }

        while (!list.isEmpty()) {
            String l = list.pollFirst();
            int count = set.get(l);
            System.out.println(l + " " + count);
        }
    }

    private static String fileName(String path) {
        String[] splits = path.split("\\\\");
        String fileName = splits[splits.length - 1];
        if (fileName.length() > 16) {
            fileName = fileName.substring(fileName.length() - 16, fileName.length());
        }
        return fileName;
    }
}
