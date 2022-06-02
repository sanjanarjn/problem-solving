package com.self.dsa.dp;

public class WaysToMakeCoinChange {
    public static int countWaysToMakeChange(int denominations[], int value){

        int[][] dp = new int[denominations.length + 1][value + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        makeChangeR(denominations, 0, value, dp);
        return dp[0][value];
    }


    private static int makeChangeR(int[] d, int si, int val, int[][] dp) {

        if(si >= d.length && val > 0)
            return 0;

        if(val < 0)
            return 0;

        if(val == 0)
            return 1;

        if(dp[si][val] != -1)
            return dp[si][val];

        int deno = d[si];
        int waysIncl = makeChangeR(d, si, val - deno, dp);
        int waysExcl = makeChangeR(d, si + 1, val, dp);

        dp[si][val] = waysExcl + waysIncl;
        return dp[si][val];
    }
}
