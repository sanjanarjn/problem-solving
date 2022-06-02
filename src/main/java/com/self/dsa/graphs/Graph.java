package com.self.dsa.graphs;

import java.util.*;

class Graph {
    
    private int n;
    private int[][] adjMatrix;

    public Graph(int n) {
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
    
    public void printBfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            queue.add(i);
            visited[i] = true;
            bfs(queue, visited);
        }
    }
    
    public void bfs(Queue<Integer> queue, boolean[] visited) {
        while(!queue.isEmpty()) {
            int vertex = queue.remove();
            System.out.print(vertex + " ");
        
            int[] neighbours = adjMatrix[vertex];
            for (int i = 0; i < n; i++) {
                if(neighbours[i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void getPathDFS(int v1, int v2) {

        boolean visited[] = new boolean[n];
        List<Integer> path = dfs(v1, v2, visited);
        if(path != null) {
            for(int elem: path)
                System.out.print(elem+ " ");
        }
    }

    public void getPathBFS(int v1, int v2) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v1);

        boolean visited[] = new boolean[n];
        visited[v1] = true;

        Map<Integer, Integer> mapping = new HashMap<>();

        boolean pathFound = false;
        while(!queue.isEmpty()) {
            int vertex = queue.remove();
            if(vertex == v2) {
                pathFound = true;
                break;
            }

            int[] neighbours = adjMatrix[vertex];
            for (int i = 0; i < n; i++) {
                if(neighbours[i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    mapping.put(i, vertex);
                }
            }
        }
        if(pathFound) {
            int curr = v2;
            while(curr != v1) {
                System.out.print(curr + " ");
                curr = mapping.get(curr);
            }
            System.out.print(curr);
        }
    }

    public List<Integer> dfs(int vertex, int dest, boolean[] visited) {

        visited[vertex] = true;
        if(vertex == dest) {
            List<Integer> path = new ArrayList<>();
            path.add(vertex);
            return path;
        }

        int[] neighbours = adjMatrix[vertex];
        for (int i = 0; i < n; i++) {
            if(neighbours[i] == 1 && !visited[i]) {
                List<Integer> path = dfs(i, dest, visited);
                if(path != null) {
                    path.add(vertex);
                    return path;
                }
            }
        }
        return null;
    }
}
