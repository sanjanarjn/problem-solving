package com.self.dsa.trees;

import java.util.ArrayList;

public class RemoveLeafNodes {
    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {

        if(root == null)
            return null;

        if(root.children == null || root.children.isEmpty())
            return null;

        ArrayList<TreeNode<Integer>> newChildren = new ArrayList<>();
        for(TreeNode<Integer> child: root.children) {
            TreeNode<Integer> newChild = removeLeafNodes(child);
            if(newChild != null)
                newChildren.add(newChild);
        }
        root.children = newChildren;
        return root;
    }
}
