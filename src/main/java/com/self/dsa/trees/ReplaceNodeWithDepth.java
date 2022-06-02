package com.self.dsa.trees;

public class ReplaceNodeWithDepth {

    public static void replaceWithDepthValue(TreeNode<Integer> root){

        replace(root, 0);
    }

    private static void replace(TreeNode<Integer> root, int depth) {
        if(root == null)
            return;

        root.data = depth;
        for(TreeNode<Integer> child: root.children) {
            replace(child, depth + 1);
        }
    }
}
