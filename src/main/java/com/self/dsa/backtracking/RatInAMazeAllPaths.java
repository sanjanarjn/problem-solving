package com.self.dsa.backtracking;

public class RatInAMazeAllPaths {
    static void ratInAMaze(int maze[][], int n) {

        int[][] path = new int[n][n];
        ratInAMaze(maze, 0,  0, path);
    }

    static void ratInAMaze(int[][] maze, int i, int j, int[][] path) {

        int n = path.length;
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1)
            return;

        path[i][j] = 1;
        if(i == n - 1 && j == n - 1) {
            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    System.out.print(path[r][c]+" ");
                }
            }
            System.out.println();
            path[i][j] = 0;
            return;
        }

        ratInAMaze(maze, i - 1, j, path);
        ratInAMaze(maze, i + 1, j, path);
        ratInAMaze(maze, i, j + 1, path);
        ratInAMaze(maze, i, j - 1, path);

        path[i][j] = 0;
    }
}
