package com.self.dsa.trees;

public class CheckIfTreeContainsX {

    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

        if(root == null)
            return false;

        if(root.data == x)
            return true;


        for(TreeNode<Integer> child : root.children) {
            boolean isChild = checkIfContainsX(child, x);
            if(isChild)
                return isChild;
        }
        return false;
    }
}
