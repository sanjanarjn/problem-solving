package com.self.dsa.dp;

/*
You are given a magic grid A with R rows and C columns. In the cells of the grid, you will either get magic juice, which increases your strength by |A[i][j]| points, or poison, which takes away |A[i][j]| strength points. If at any point of the journey, the strength points become less than or equal to zero, then you will die.
You have to start from the top-left corner cell (1,1) and reach at the bottom-right corner cell (R,C).
From a cell (i,j), you can only move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) and you can not move outside the magic grid. You have to find the minimum number of strength points with which you will be able to reach the destination cell.

 */
public class MagicGrid {
    public static int getMinimumStrength(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] health = new int[m][n];

        health[m - 1][n - 1] = 1;
        health[m - 2][n - 1] = 1;
        health[m - 1][n - 2] = 1;

        for(int row = m - 3; row >=0; row--) {
            int minHealth = health[row + 1][n - 1] - grid[row + 1][n - 1];
            health[row][n - 1] = minHealth > 0 ? minHealth : 1;
        }

        for(int col = n - 3; col >=0; col--) {
            int minHealth = health[m - 1][col + 1] - grid[m - 1][col + 1];
            health[m - 1][col] = minHealth > 0 ? minHealth : 1;
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {

                int rightHealth = health[i][j + 1] - grid[i][j + 1];
                rightHealth = rightHealth > 0 ? rightHealth : 1;

                int downHealth = health[i + 1][j] - grid[i + 1][j];
                downHealth = downHealth > 0 ? downHealth : 1;

                health[i][j] = Math.min(rightHealth, downHealth);
            }
        }
        return health[0][0];
    }
}
