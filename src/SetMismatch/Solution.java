package SetMismatch;

//  645. Set Mismatch

//    The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
//    one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//    Given an array nums representing the data status of this set after the error.
//    Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int correctSum = ((1 + n) * n) / 2;
        int sum = 0;
        int numberOccursTwice = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            if (list.contains(num)) {
                numberOccursTwice = num;
            } else list.add(num);
        }
        return new int[]{numberOccursTwice, numberOccursTwice + correctSum - sum};
    }
}
