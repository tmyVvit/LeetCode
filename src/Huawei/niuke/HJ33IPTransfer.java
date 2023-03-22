package Huawei.niuke;

import java.util.Scanner;

public class HJ33IPTransfer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String ip = sc.next();
            long number = sc.nextLong();
            System.out.println(ipToLong(ip));
            System.out.println(longToIP(number));
        }
    }

    private static long ipToLong(String ip) {
        String[] ips = ip.split("\\.");
        long num = 0;
        num |= (Long.parseLong(ips[0]) << 24);
        num |= (Long.parseLong(ips[1]) << 16);
        num |= (Long.parseLong(ips[2]) << 8);
        num |= Long.parseLong(ips[3]);
        return num;
    }

    private static String longToIP(long num) {
        int[] ips = new int[4];
        ips[3] = (int)(num & 0xff);
        ips[2] = (int)((num >> 8) & 0xff);
        ips[1] = (int)((num >> 16) & 0xff);
        ips[0] = (int)((num >> 24) & 0xff);
        return String.format("%d.%d.%d.%d", ips[0], ips[1], ips[2], ips[3]);
    }
}
