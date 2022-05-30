package com.self.dsa.trees;

public class NodesWithoutSibling {

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {

        if(root == null)
            return;

        if(root.left == null && root.right == null) {
            return;
        }

        if(root.left != null && root.right == null) {
            System.out.print(root.left.data+" ");
        }
        if(root.left == null && root.right.data != null) {
            System.out.print(root.right.data+" ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }
}
