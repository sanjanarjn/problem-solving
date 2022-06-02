package com.self.dsa.backtracking;

public class NQueens {
    public static void placeNQueens(int n){
        int[][] board = new int[n][n];
        place(board, 0, n);
    }

    private static boolean place(int[][] board, int i, int n) {

        if(i == n) {
            for(int r=0; r<n; r++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(board[r][c] + " ");
                }
            }
            System.out.println();
            return true;

        }

        boolean conflicting = true;
        for(int j = 0; j < n; j++) {
            board[i][j] = 1;
            conflicting = isConflicting(board, i ,j);
            if(!conflicting) {
                conflicting = place(board, i + 1, n);
            }
            if(!conflicting)
                break;
            else
                board[i][j] = 0;
        }
        return conflicting;

    }

    private static boolean isConflicting(int[][] board, int i, int j) {

        int n = board.length;
        boolean conflicting =  isRowConflicting(board, i, j, n) ||
                isColumnConflicting(board, i, j, n) ||
                isDiagonalConflicting(board, i, j, n);

        return conflicting;

    }


    private static boolean isDiagonalConflicting(int[][] board, int i, int j, int n) {

        boolean conflicting = false;
        //up left
        int row = i - 1, col = j - 1;
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 1) {
                conflicting = true;
                break;
            }
            row--;
            col--;
        }

        if(conflicting)
            return true;

        //up right
        row = i - 1; col = j + 1;
        while(row >= 0 && col < n) {
            if(board[row][col] == 1) {
                conflicting = true;
                break;
            }
            row--;
            col++;
        }

        if(conflicting)
            return true;

        //down left
        row = i + 1; col = j - 1;
        while(row < n && col >= 0) {
            if(board[row][col] == 1) {
                conflicting = true;
                break;
            }
            row++;
            col--;
        }

        if(conflicting)
            return true;

        //down right
        row = i + 1; col = j + 1;
        while(row < n && col < n) {
            if(board[row][col] == 1) {
                conflicting = true;
                break;
            }
            row++;
            col++;
        }

        return conflicting;

    }

    private static boolean isRowConflicting(int[][] board, int i, int j, int n) {

        boolean conflicting = false;
        for(int col = 0; col < n; col++) {
            if(col == j)
                continue;
            if(board[i][col] == 1) {
                conflicting = true;
                break;
            }
        }
        return conflicting;
    }

    private static boolean isColumnConflicting(int[][] board, int i, int j, int n) {

        boolean conflicting = false;
        for(int row = 0; row < n; row++) {
            if(row == i)
                continue;
            if(board[row][j] == 1) {
                conflicting = true;
                break;
            }
        }
        return conflicting;
    }
}
