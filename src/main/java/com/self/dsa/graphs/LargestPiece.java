package com.self.dsa.graphs;

/*
It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?

 */
public class LargestPiece {
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int dfs(String[] edge, int n) {

        int max = Integer.MIN_VALUE;

        boolean[][] visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String s = edge[i];
            for(int j = 0; j < n; j++) {
                char c = s.charAt(i);
                if(c == '1') {
                    if(!visited[i][j])
                        max = Math.max(max, dfs(i, j, edge, visited));
                }
            }
        }
        return max;
    }

    private static int dfs(int i, int j, String[] edge, boolean[][] visited) {

        if(i < 0 || i >= edge.length || j < 0 || j >= edge[i].length() || visited[i][j] || edge[i].charAt(j) == '0')
            return 0;

        visited[i][j] = true;
        return 1 + dfs(i + 1, j, edge, visited) + dfs(i, j + 1, edge, visited) +
                dfs(i - 1, j, edge, visited) + dfs(i, j - 1, edge, visited);
    }
}

