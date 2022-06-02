package com.self.dsa.dp;


/*

An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.

 */
public class MinCostPath {

    public static int minCostPath(int[][] input) {

        if(input == null || input.length == 0)
            return 0;

        int m = input.length;
        int n = input[0].length;
        int[][] cost = new int[m][n];

        cost[m - 1][n - 1] = input[m - 1][n - 1];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1){
                    continue;
                }
                int rightCost = j < n - 1 ? cost[i][j + 1] : Integer.MAX_VALUE;
                int downCost = i < m - 1 ? cost[i+1][j] : Integer.MAX_VALUE;
                int diagonalCost = i < m - 1 && j < n - 1 ? cost[i+1][j+1]: Integer.MAX_VALUE;

                cost[i][j] = input[i][j] + Math.min(rightCost, Math.min(downCost, diagonalCost));
            }
        }
        return cost[0][0];
    }
}




