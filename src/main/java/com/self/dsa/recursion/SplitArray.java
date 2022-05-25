package com.self.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

/**
Given an integer array A of size N, check if the input array can be splitted in two parts such that -
    - Sum of both parts is equal
    - All elements in the input, which are divisible by 5 should be in same group.
    - All elements in the input, which are divisible by 3 (but not divisible by 5) should be in other group.
    - Elements which are neither divisible by 5 nor by 3, can be put in any group.
Groups can be made with any set of elements, i.e. elements need not to be continuous. And you need to consider each and every element of input array in some group.
Return true, if array can be split according to the above rules, else return false.
 **/

public class SplitArray {

    public static boolean splitArray(int input[]) {

        int otherSum = 0;
        int fiveSum = 0;
        int threeSum = 0;

        List<Integer> others = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {

            int elem = input[i];

            if (elem % 5 == 0) {
                fiveSum += elem;
            } else if (elem % 3 == 0) {
                threeSum += elem;
            } else {
                others.add(elem);
                otherSum += elem;
            }
        }
        boolean canSplit = false;

        if (others.size() == 0) {
            canSplit = fiveSum == threeSum;
        } else {
            canSplit = splitOthers(others, 0, fiveSum, threeSum);
        }

        return canSplit;
    }

    private static boolean splitOthers(List<Integer> others, int si, int sum1, int sum2) {

        if (si >= others.size()) {
            return sum1 == sum2;
        }

        //System.out.println("FiveSum : "+sum1+" ThreeSum : "+sum2);
        int elem = others.get(si);
        return splitOthers(others, si + 1, sum1 + elem, sum2) || splitOthers(others, si + 1, sum1, sum2 + elem);

    }
}
