package com.self.dsa.dp;

public class SubsetSumToKPresent {
    static boolean isSubsetPresent(int[] arr, int n, int sum) {

        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        checkForSubset(arr, 0, n, sum, dp);
        boolean subsetFound = dp[0][sum] == 1;
        /*for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+"    ");
            }
            System.out.println();
        }*/
        return subsetFound;

    }

    private static boolean checkForSubset(int[] arr, int si, int n, int sum, int[][] dp) {

        if(si == n)
            return sum == 0;

        if(dp[si][sum] != -1)
            return dp[si][sum] == 1;

        boolean subsetFound = false;
        int elem = arr[si];
        if(sum >= elem) {
            subsetFound = checkForSubset(arr, si + 1, n, sum - elem, dp);
        }
        if(!subsetFound) {
            subsetFound = checkForSubset(arr, si + 1, n, sum, dp);
        }
        dp[si][sum] = subsetFound ? 1 : 0;
        return subsetFound;
    }
}
