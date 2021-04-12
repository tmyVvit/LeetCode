package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] nums = {0, 0, 0};
        System.out.println(Integer.compare(2, 3));
        System.out.println(largestNumber.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length(), len2 = o2.length();
                int len = Math.min(len1, len2);
                for (int i = 0; i < len; i++) {
                    if (o1.charAt(i) > o2.charAt(i)) return -1;
                    else if (o1.charAt(i) < o2.charAt(i)) return 1;
                }
                if (len1 == len2) return 0;
                if (len1 > len2) {
                    return compare(o1.substring(len), o2);
                } else {
                    return compare(o1, o2.substring(len));
                }
            }
        };
        List<String> list = arrToList(nums);

        list.sort(comparator);
        String result = listToString(list);
        return postProcessResultString(result);
    }

    private String postProcessResultString(String res) {
        int start = 0;
        while(start < res.length()) {
            if (res.charAt(start) == '0') start++;
            else break;
        }
        return res.substring(start == 0 ? 0 : start - 1);
    }

    private List<String> arrToList(int[] nums) {
        assert nums != null && nums.length != 0;
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        return list;
    }

    private String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }
}
