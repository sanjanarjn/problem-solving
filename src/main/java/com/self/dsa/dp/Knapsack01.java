package com.self.dsa.dp;

public class Knapsack01 {
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        return knapsackDp(weights, values, maxWeight);
        //return 0;
    }

    private static int knapsackDp(int[] w, int[] v, int max) {

        int[][] dp = new int[w.length + 1][max + 1];

        int n = w.length;
        for(int i = n - 1; i >= 0; i--) {
            int wt = w[i];
            int val = v[i];
            for (int j = 1; j <= max; j++) {
                int W = j;
                if(wt <= W) {
                    dp[i][j] = Math.max(val + dp[i+1][W - wt], dp[i + 1][W]);
                }
                else {
                    dp[i][j] = dp[i + 1][W];
                }
            }
        }
        return dp[0][max];
    }

    private static int knapsackR(int[] w, int[] v, int si, int max) {

        if(si == w.length)
            return 0;

        if(max == 0) {
            return 0;
        }

        int weight = w[si];
        int value = v[si];
        int x = max >= weight ? value + knapsackR(w, v, si + 1, max - weight) : 0;
        int y = knapsackR(w, v, si + 1, max);

        return Math.max(x, y);
    }
}
