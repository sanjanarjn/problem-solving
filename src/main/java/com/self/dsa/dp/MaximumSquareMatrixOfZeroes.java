package com.self.dsa.dp;

/*
Given an NxM matrix that contains only 0s and 1s, find out the size of the maximum square sub-matrix with all 0s.
You need to return the size of the square matrix with all 0s.
 */
public class MaximumSquareMatrixOfZeroes {
    public static int findMaxSquareWithAllZeros(int[][] matrix) {

        if(matrix.length <= 1)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int maxLen = 0;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m -1 || j == n - 1) {
                    dp[i][j] = matrix[i][j] == 0 ? 1 : 1;

                }
                else {
                    int min = Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
                    if(matrix[i][j] == 0) {
                        dp[i][j] = 1 + min;
                    }

                }

                if(maxLen < dp[i][j])
                    maxLen = dp[i][j];
            }
        }
        return maxLen;
    }
}
