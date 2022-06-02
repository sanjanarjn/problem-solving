package com.self.dsa.dp;

/*
Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
 */
public class MinSquares {
    public static int minCount(int n) {

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i <= n; i++) {
            int minSquare = (int) Math.sqrt(i);
            int minCount = Integer.MAX_VALUE;

            for(int j=1; j <= minSquare; j++) {
                int count = dp[i - j*j];
                if(count < minCount)
                    minCount = count;
            }
            dp[i] = 1 + minCount;
        }
        return dp[n];
    }
}
