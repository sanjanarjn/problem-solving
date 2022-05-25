package com.self.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsetsWithGivenSum {

    public static List<List<Integer>> getAllSubsetsWithGivenSum(List<Integer> input, int sum) {

        return getSubsetsWithSum(input, 0, sum);
    }

    private static List<List<Integer>> getSubsetsWithSum(List<Integer> input, int i, int sum) {

        if (sum == 0) {
            List<Integer> subset = new ArrayList<>();
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(subset);
            return subsets;
        }

        if (sum < 0)
            return null;

        if (i >= input.size())
            return null;

        int current = input.get(i);

        List<List<Integer>> with = getSubsetsWithSum(input, i + 1, sum - current);
        List<List<Integer>> without = getSubsetsWithSum(input, i + 1, sum);

        List<List<Integer>> all = new ArrayList<>();
        if (with != null) {
            for (List<Integer> subset : with) {
                subset.add(current);
            }
            all.addAll(with);
        }
        if (without != null)
            all.addAll(without);

        return all;
    }

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(9);
        input.add(7);
        input.add(5);
        input.add(8);

        System.out.println(getAllSubsetsWithGivenSum(input, 17));
    }
}
