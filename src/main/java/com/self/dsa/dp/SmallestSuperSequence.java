package com.self.dsa.dp;

/*
Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.
 The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have both the given strings as its subsequences.

 */
public class SmallestSuperSequence {
    public static int smallestSuperSequence(String str1, String str2) {

        int[][]  dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        superSequence(str1, 0, str2, 0, dp);


        return dp[0][0];
    }

    private static int superSequence(String s1, int p1, String s2, int p2, int[][] dp) {

        int m = s1.length();
        int n = s2.length();

        if(p1 == m && p2 == n) {
            dp[p1][p2] = 0;
            return 0;
        }
        else if (p1 == m && p2 < n) {
            dp[p1][p2] = n - p2;
            return dp[p1][p2];
        }
        else if(p1 < m && p2 == n) {
            dp[p1][p2] =  m - p1;
            return dp[p1][p2];
        }



        if(dp[p1][p2] != -1)
            return dp[p1][p2];

        if(s1.charAt(p1) != s2.charAt(p2)) {
            dp[p1][p2] = 1 + Math.min(superSequence(s1, p1 + 1, s2, p2, dp), superSequence(s1, p1, s2, p2+1, dp));
        }
        else {
            dp[p1][p2] = 1 + superSequence(s1, p1+1, s2, p2+1, dp);
        }
        return dp[p1][p2];
    }
}
