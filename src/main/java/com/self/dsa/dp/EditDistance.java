package com.self.dsa.dp;

public class EditDistance {
    public static int editDistance(String s, String t) {

        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];

        dp[m][n] = 0;
        for(int i = m; i >= 0; i--) {
            dp[i][n] = m - i;
        }

        for(int j = n; j >= 0; j--) {
            dp[m][j] = n - j;
        }

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {

                int rightEdit = dp[i][j+1];
                int downEdit =  dp[i+1][j] ;
                int diagEdit =  dp[i+1][j+1];

                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = diagEdit;
                }
                else {
                    dp[i][j] = 1 + Math.min(diagEdit, Math.min(rightEdit, downEdit));
                }
            }
        }
        return dp[0][0];
    }
}
