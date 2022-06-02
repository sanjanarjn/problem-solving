package com.self.dsa.graphs;

import java.util.*;

public class ConnectedComponents {

    private int n;
    private int[][] adjMatrix;

    public ConnectedComponents(int n) {
        this.n = n;
        this.adjMatrix = new int[n][n];
    }

    public void addEdge(int v1, int v2) {
        this.adjMatrix[v1][v2] = 1;
        this.adjMatrix[v2][v1] = 1;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void getComponents() {

        if(n == 0)
            return;

        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++) {
            bfs(i, visited);
            System.out.println();
        }
    }

    public void bfs(int vertex, boolean[] visited) {

        List<Integer> path = new ArrayList<>();
        if(!visited[vertex]) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(vertex);
            visited[vertex] = true;

            while(!queue.isEmpty()) {
                int curr = queue.remove();
                path.add(curr);
                int[] neighbours = adjMatrix[curr];

                for(int i = 0; i < n; i++) {
                    if(neighbours[i] == 1 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            Collections.sort(path);
            for(int elem : path) {
                System.out.print(elem + " ");
            }
        }
    }
}
