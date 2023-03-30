package Huawei.shangji;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Set<Integer>[] daily = new Set[32];
            for (int i = 0; i < 32; i++) {
                daily[i] = new HashSet<>();
            }
            int count = sc.nextInt();

            for (int i = 0; i < count; i++) {
                String line = sc.next();
                String[] logs = line.split("\\|");
                if ("/login.do".equals(logs[2]) && "success".equals(logs[3])) {
                    int ip = resolveIP(logs[1]);
                    int date = date(logs[0]);

                    daily[0].add(ip);
                    daily[date].add(ip);
                }
            }
            for (int i = 0; i < daily.length; i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(daily[i].size());
            }
        }
    }

    private static int date(String time) {
        String[] splits = time.split("-");
        return Integer.parseInt(splits[2]);
    }

    private static int resolveIP(String ip) {
        String[] ips = ip.split("\\.");
        int res = 0;
        res |= Integer.parseInt(ips[0]) << 24;
        res |= Integer.parseInt(ips[1]) << 16;
        res |= Integer.parseInt(ips[2]) << 8;
        res |= Integer.parseInt(ips[3]);
        return res;
    }
}
