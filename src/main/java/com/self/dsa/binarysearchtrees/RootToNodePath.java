package com.self.dsa.binarysearchtrees;

import java.util.ArrayList;

/**
 Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST) in a list. Return empty list otherwise.

 */
public class RootToNodePath {

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){


        if(root == null)
            return new ArrayList<>();

        ArrayList<Integer> path = null;
        if(root.data == data) {
            path = new ArrayList<>();
            path.add(data);
            return path;
        }
        else if(data > root.data) {
            path = getPath(root.right, data);
        }
        else {
            path = getPath(root.left, data);
        }
        if(path != null && !path.isEmpty()) {
            path.add(root.data);
        }
        return path;
    }
}
