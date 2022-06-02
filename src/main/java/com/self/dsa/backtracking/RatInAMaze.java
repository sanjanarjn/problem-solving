package com.self.dsa.backtracking;

public class RatInAMaze {

    public static boolean ratInAMaze(int maze[][]){

        int[][] visited = new int[maze.length][maze[0].length];
        return ratInAMaze(maze, 0, 0, visited);
    }

    private static boolean ratInAMaze(int[][] maze, int i, int j, int[][] visited) {

        if(i < 0 || i >= maze.length || j < 0 || j >= maze.length || visited[i][j] == 1 || maze[i][j] == 0)
            return false;

        if(i == maze.length - 1 && j == maze.length - 1)
            return true;

        visited[i][j] = 1;

        boolean pathFound = ratInAMaze(maze, i - 1, j, visited);
        if(!pathFound) {
            pathFound = ratInAMaze(maze, i, j + 1, visited);
        }
        if(!pathFound) {
            pathFound = ratInAMaze(maze, i+1, j, visited);
        }
        if(!pathFound) {
            pathFound = ratInAMaze(maze, i, j-1, visited);
        }
        //visited[i][j] = 0;
        return pathFound;
    }
}
