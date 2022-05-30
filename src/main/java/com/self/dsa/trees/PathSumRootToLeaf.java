package com.self.dsa.trees;

import java.util.ArrayList;
import java.util.List;

/**

 For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.

 */
public class PathSumRootToLeaf {

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        List<String> paths = findPaths(root, k);
        for(String path : paths) {
            System.out.println(path);
        }
    }

    private static List<String> findPaths(BinaryTreeNode<Integer> node, int sum) {

        if(node == null)
            return new ArrayList<>();

        if(node.left == null && node.right == null && sum == node.data) {
            List<String> path = new ArrayList<>();
            path.add(node.data+"");
            return path;
        }

        List<String> leftPaths = findPaths(node.left, sum - node.data);
        List<String> rightPaths = findPaths(node.right, sum - node.data);

        List<String> allPaths = new ArrayList<>();
        for(String lPath : leftPaths) {
            allPaths.add(node.data +" "+lPath);
        }
        for(String rPath: rightPaths) {
            allPaths.add(node.data + " " + rPath);
        }
        return allPaths;
    }
}
