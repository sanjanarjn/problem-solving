package com.self.dsa.graphs;

import java.util.HashMap;
import java.util.Map;

/*

Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.

 */
public class CodingNinjas {

    final char[] path = new char[]{'C', 'O', 'D', 'I', 'N', 'G', 'N', 'I', 'N', 'J', 'A'};
    Map<String, Boolean> visited = new HashMap<>();

    int solve(String[] Graph , int N, int M) {

        int found = 0;

        for(int i = 0; i < N; i++) {
            String s = Graph[i];
            for(int j = 0; j < M; j++) {
                if(s.charAt(j) == 'C') {
                    if(!visited.containsKey(visitedKey(i, j))) {
                        visited.put(visitedKey(i, j), true);
                        found = bfs(i, j, Graph, 1);
                        if(found == 1)
                            return 1;
                    }
                }
            }
        }

        return found;
    }

    private int bfs(int i, int j, String[] Graph, int pathIndex) {

        if(pathIndex == path.length)
            return 1;

        for(int row = i - 1; row <= i + 1; row++) {
            for(int col = j - 1; col <= j + 1; col++) {
                if(row == i && col == j)
                    continue;

                if(row < 0 || row >= Graph.length || col < 0 || col >= Graph[0].length())
                    continue;

                if(!visited.containsKey(visitedKey(row, col)) && Graph[row].charAt(col) == path[pathIndex]) {
                    visited.put(visitedKey(row, col), true);
                    int answer = bfs(row, col, Graph, pathIndex + 1);
                    if(answer == 1)
                        return answer;
                    else
                        visited.remove(visitedKey(row, col));
                }
            }
        }
        return 0;
    }

    private String visitedKey(int i, int j) {
        return i+"_"+j;
    }
}
