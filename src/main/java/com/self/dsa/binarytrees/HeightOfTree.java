package com.self.dsa.binarytrees;

/**
    10
   /  \
 20   30
 /     \
 40    50

 Height of the given tree is 3.

 Height is defined as the total number of nodes along the longest path from the root to any of the leaf node.

 */
public class HeightOfTree {
    public static int height(BinaryTreeNode<Integer> root) {

        if(root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
