package com.self.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateSubsets {

    private static List<String> getSubsets(String input) {
        return getSubsets(input, 0);
    }

    private static List<String> getSubsets(String input, int i) {

        if (i == input.length()) {
            List<String> subsets = new ArrayList<>();
            subsets.add("");
            return subsets;
        }

        List<String> withoutSubsets = getSubsets(input, i + 1);
        List<String> withSubsets = new ArrayList<>();
        for (String without : withoutSubsets) {
            withSubsets.add(input.charAt(i) + without);
        }
        List<String> allSubsets = new ArrayList<>();
        allSubsets.addAll(withoutSubsets);
        allSubsets.addAll(withSubsets);

        return allSubsets;
    }

    public static void main(String[] args) {
        System.out.println(getSubsets("abc"));
    }
}
