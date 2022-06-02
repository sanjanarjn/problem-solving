package com.self.dsa.dp;

/*
A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses.
Find the maximum amount of money he can loot.

 */
public class HouseRobber {

    public static int maxMoneyLooted(int[] houses) {

        if(houses == null || houses.length == 0)
            return 0;

        if(houses.length == 1)
            return houses[0];

        int n = houses.length;
        int[] dp = new int[n];

        dp[n - 1] = houses[n - 1];
        dp[n - 2] = Math.max(houses[n - 1], houses[n - 2]);

        for(int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(houses[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }
}
