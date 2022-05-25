package com.self.dsa.recursion;

/**
Does s contain t ?

Given two string s and t, write a function to check if s contains all characters of t (in the same order as they are in string t).
Return true or false.

E.g. : s = “abchjsgsuohhdhyrikkknddg” contains all characters of t=”coding” in the same order. So function will return true.
**/

public class CheckSequence {

    public static boolean checkSequence(String a, String b) {
        int aPos = 0;
        int bPos = 0;

        while(aPos < a.length() && bPos < b.length()) {

            char aChar = a.charAt(aPos);
            char bChar = b.charAt(bPos);

            if(aChar == bChar) {
                bPos++;
            }
            aPos++;
        }
        return bPos == b.length();
    }
}
