package com.self.dsa.graphs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsConnectedGraph {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ConnectedGraph graph = new ConnectedGraph(n);

        int e = scanner.nextInt();
        for (int i = 0; i < e; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();

            graph.addEdge(v1, v2);
        }
        System.out.println(graph.isConnected());
    }
}

class ConnectedGraph {

    private int n;
    private int[][] adjMatrix;

    public ConnectedGraph(int n) {
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

    public boolean isConnected() {

        if(n == 0)
            return true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        boolean visited[] = new boolean[n];
        visited[0] = true;

        while(!queue.isEmpty()) {
            int vertex = queue.remove();

            int[] neighbours = adjMatrix[vertex];
            for (int i = 0; i < n; i++) {
                if(neighbours[i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        for(boolean eachVisited : visited) {
            if(!eachVisited)
                return false;
        }
        return true;
    }

}