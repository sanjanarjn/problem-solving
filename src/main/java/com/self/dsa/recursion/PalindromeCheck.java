package com.self.dsa.recursion;

public class PalindromeCheck {

    public static boolean isPalindrome(String s) {

        if (s == null) return false;
        return isPalindrome(s, 0, s.length() - 1);
    }

    private static boolean isPalindrome(String s, int start, int end) {

        if (start >= end) return true;
        if (s.charAt(start) == s.charAt(end))
            return isPalindrome(s, start + 1, end - 1);
        else
            return false;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abc"));
    }
}
