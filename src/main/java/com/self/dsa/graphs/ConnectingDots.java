package com.self.dsa.graphs;

/*

Gary has a board of size NxM. Each cell in the board is a coloured dot. There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B,...,Z). Now Gary is getting bored and wants to play a game. The key of this game is to find a cycle that contain dots of same colour. Formally, we call a sequence of dots d1, d2, ..., dk a cycle if and only if it meets the following condition:
1. These k dots are different: if i ≠ j then di is different from dj.
2. k is at least 4.
3. All dots belong to the same colour.
4. Also, dk and d1 should also be adjacent. Cells x and y are called adjacent if they share an edge.
Since Gary is colour blind, he wants your help. Your task is to determine if there exists a cycle on the board.

 */
public class ConnectingDots {

    int n;
    int m;

    int solve(String[] board , int n, int m) {

        this.n = n;
        this.m = m;

        boolean visited[][] = new boolean[n][m];

        boolean cycleFound = false;
        for(int i = 0; i < board.length; i++) {
            String s = board[i];
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                cycleFound = bfs(board, i, j, i, j, c, 0, visited);
                if(cycleFound)
                    return 1;
            }
        }
        return cycleFound ? 1 : 0;
    }

    private boolean bfs(String[] board, int i, int j, int startI, int startJ, char c, int steps, boolean[][] visited) {

        if(i == startI && j == startJ && steps >= 4) {
            return true;
        }

        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j])
            return false;

        if(board[i].charAt(j) == c) {
            visited[i][j] = true;
            boolean cycleFound = bfs(board, i + 1, j, startI, startJ, c, steps + 1, visited);
            if(!cycleFound)
                cycleFound = bfs(board, i, j + 1, startI, startJ, c, steps + 1, visited);
            if(!cycleFound)
                cycleFound = bfs(board, i - 1, j, startI, startJ, c, steps + 1, visited);
            if(!cycleFound)
                cycleFound = bfs(board, i, j - 1, startI, startJ, c, steps + 1, visited);

            if (cycleFound)
                return true;

            visited[i][j] = false;
        }

        return false;
    }
}
