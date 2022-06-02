package com.self.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {
    public static void printSubsets(int input[]) {

        printSubsets(input, 0, new ArrayList<>());
    }

    private static void printSubsets(int[] input, int si, List<Integer> output) {

        if(si == input.length) {

            if(output.size() > 0) {
                for(int num: output) {
                    System.out.print(num+" ");
                }
                System.out.println();
            }
            return;
        }

        List<Integer> newOutput = new ArrayList<>(output);
        newOutput.add(input[si]);

        printSubsets(input, si + 1, output);
        printSubsets(input, si + 1, newOutput);
    }
}
