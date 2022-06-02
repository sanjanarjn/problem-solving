package com.self.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*

An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 1 to V) and E connections or edges between islands. Can you count the number of connected groups of islands.

 */
public class Islands {

    public static int numConnected(int[][] matrix, int n) {

        if(n == 0)
            return 0;

        int count = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++) {
            boolean notVisited = bfs(matrix, i, visited);
            if(notVisited)
                count++;
        }
        return count;
    }

    public static boolean bfs(int[][] matrix, int vertex, boolean[] visited) {

        if(!visited[vertex]) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(vertex);
            visited[vertex] = true;

            while(!queue.isEmpty()) {
                int curr = queue.remove();
                int[] neighbours = matrix[curr];

                for(int i = 0; i < neighbours.length; i++) {
                    if(neighbours[i] == 1 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
