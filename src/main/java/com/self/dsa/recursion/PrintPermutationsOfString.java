package com.self.dsa.recursion;

public class PrintPermutationsOfString {
    public static void permutations(String input){

        permute(input, 0, "");
    }

    private static void permute(String s, int si, String prefix) {

        if(si == s.length()) {
            System.out.println(prefix);
        }

        for(int i = si; i < s.length(); i++) {
            String swapped = swap(s, si, i);
            permute(swapped, si + 1, swapped.substring(0, si + 1));
        }
    }

    private static String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();

        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return new String(charArray);
    }
}
