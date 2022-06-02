package com.self.dsa.binarytrees;

import java.util.ArrayList;
/*
Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.
 */
public class LongestLeafToRootPath {
    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
        ArrayList<ArrayList<Integer>> paths = getPaths(root);

        int max = Integer.MIN_VALUE;
        ArrayList<Integer> longestPath = null;
        for(ArrayList<Integer> path : paths) {
            if(path.size() > max) {
                max = path.size();
                longestPath = path;
            }
        }
        return longestPath;
    }

    private static ArrayList<ArrayList<Integer>> getPaths(BinaryTreeNode<Integer> node) {

        if(node == null)
            return new ArrayList<>();

        if(node.left == null && node.right == null) {
            ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            paths.add(path);
            return paths;
        }

        ArrayList<ArrayList<Integer>> leftPaths = getPaths(node.left);
        ArrayList<ArrayList<Integer>> rightPaths = getPaths(node.right);
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        for(ArrayList<Integer> leftPath: leftPaths) {
            leftPath.add(node.data);
            allPaths.add(leftPath);
        }
        for(ArrayList<Integer> rightPath: rightPaths) {
            rightPath.add(node.data);
            allPaths.add(rightPath);
        }
        return allPaths;
    }
}
