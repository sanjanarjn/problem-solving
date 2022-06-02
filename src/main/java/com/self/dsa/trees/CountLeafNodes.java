package com.self.dsa.trees;

public class CountLeafNodes {
    public static int countLeafNodes(TreeNode<Integer> root){

        if(root == null)
            return 0;

        if(root.children == null || root.children.isEmpty())
            return 1;

        int childLeafCount = 0;
        for(TreeNode<Integer> child: root.children) {
            childLeafCount += countLeafNodes(child);
        }
        return childLeafCount;

    }
}
