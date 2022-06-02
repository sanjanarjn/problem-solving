package com.self.dsa.dp;

public class MinStepsToOne {
    public static int countMinStepsToOne(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= n; i++) {
            int x = dp[i-1];
            int y = i % 2 == 0 ? dp[i/2] : Integer.MAX_VALUE;
            int z = i % 3 == 0 ? dp[i/3] : Integer.MAX_VALUE;

            dp[i] = 1 + Math.min(x, Math.min(y, z));
        }
        return dp[n];
    }
}
