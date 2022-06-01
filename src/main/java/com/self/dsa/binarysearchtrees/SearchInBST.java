package com.self.dsa.binarysearchtrees;

public class SearchInBST {
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {

        if(root == null)
            return false;

        if(root.data == k)
            return true;
        else if(k < root.data)
            return searchInBST(root.left, k);
        else
            return searchInBST(root.right, k);
    }
}
