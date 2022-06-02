package com.self.dsa.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges, then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.

 */
public class ThreeCycle {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int solve(boolean[][] graph, int n) {

        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            count += dfs(i, i, 0, graph, visited);
        }
        return count/6;
    }

    private static int dfs(int i, int start,
                           int steps, boolean[][] graph, boolean[] visited) {

        if(steps >= 3)
        {
            return 0;
        }

        visited[i] = true;
        int count = 0;
        boolean[] neighbours = graph[i];
        for(int idx = 0; idx < neighbours.length; idx++) {

            if(neighbours[idx] && idx == start && steps == 2) {
                count = 1;
                break;
            }


            if(neighbours[idx] && !visited[idx]) {
                count += dfs(idx, start, steps + 1, graph, visited);
            }
        }
        visited[i] = false;
        return count;

    }

    public static boolean[][] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int m = Integer.parseInt(strNums[1]);

        boolean[][] graphs = new boolean[n][n];
        int firstvertex, secondvertex;

        for (int i = 0; i < m; i++) {
            String[] strNums1;
            strNums1 = br.readLine().split("\\s");
            firstvertex = Integer.parseInt(strNums1[0]);
            secondvertex = Integer.parseInt(strNums1[1]);
            graphs[firstvertex][secondvertex] = true;
            graphs[secondvertex][firstvertex] = true;
        }
        return graphs;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        boolean[][] graphs = takeInput();

        int ans = solve(graphs, graphs.length);
        System.out.println(ans);

    }
}
