package com.self.dsa.trees;

public class MirrorBinaryTree {

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){

        if(root == null)
            return;

        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

        BinaryTreeNode<Integer> mirrorLeft = root.left;
        BinaryTreeNode<Integer> mirrorRight = root.right;

        root.right = mirrorLeft;
        root.left = mirrorRight;
    }
}
