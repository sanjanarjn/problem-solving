package com.self.dsa.trees;

public class NumberOfNodesGreaterThanX {
    public static int numNodeGreater(TreeNode<Integer> root,int x){

        if(root == null)
            return 0;

        int childCount = 0;
        for(TreeNode<Integer> child: root.children) {
            childCount += numNodeGreater(child, x);
        }
        return root.data > x ? childCount + 1:childCount;

    }
}
