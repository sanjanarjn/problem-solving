package com.self.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsetsSumToK {
    public static void printSubsetsSumTok(int input[], int k) {

        printSubsets(input, k, 0, new ArrayList<>());
    }

    private static void printSubsets(int[] input, int sum, int si, List<Integer> output) {

        if(sum == 0) {
            if(output.size() > 0) {
                for(int num : output) {
                    System.out.print(num+" ");
                }
                System.out.println();
            }
            return;
        }

        if(si == input.length)
            return;

        printSubsets(input, sum, si + 1, output);
        if(input[si] <= sum) {
            List<Integer> newOutput = new ArrayList<>(output);
            newOutput.add(input[si]);
            printSubsets(input, sum - input[si], si + 1, newOutput);
        }
    }
}
