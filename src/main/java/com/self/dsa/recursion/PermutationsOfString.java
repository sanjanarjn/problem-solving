package com.self.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {
    public static String[] permutationOfString(String input){

        if(input.length() <= 1)
            return new String[]{input};

        return permute(input, 0);
    }

    private static String[] permute(String s, int si) {

        if(si == s.length() - 1)
            return new String[]{s};

        if(si == s.length())
            return new String[0];

        List<String> output = new ArrayList<>();

        for(int i = si; i < s.length(); i++) {
            String swapped = swap(s, si, i);
            String[] permuted = permute(swapped, si+1);
            for(String each: permuted) {
                output.add(each);
            }
        }
        String[] outputArray = new String[output.size()];

        int i = 0;
        for(String out: output) {
            outputArray[i++] = out;
        }
        return outputArray;
    }

    private static String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        return new String(chars);
    }
}
