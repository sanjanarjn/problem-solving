package com.self.dsa.binarytrees;

/**

 or a given a Binary Tree of integers, replace each of its data with the depth of the tree.
 Root is at depth 0, hence the root data is updated with 0.
 Replicate the same further going down the in the depth of the given tree.
 The modified tree will be printed in the in-order fashion.
 */
public class ReplaceNodesWithDepth {

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        changeToDepthTree(root, 0);
    }

    private static void changeToDepthTree(BinaryTreeNode<Integer> root, int depth) {

        if(root == null)
            return;

        root.data = depth;
        changeToDepthTree(root.left, depth + 1);
        changeToDepthTree(root.right, depth + 1);
    }

}
