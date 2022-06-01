package com.self.dsa.binarysearchtrees;

public class BSTFromSortedArray {
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {

        if (n == 0)
            return null;

        return insert(arr, 0, n - 1);
    }

    private static BinaryTreeNode<Integer> insert(int[] arr, int si, int ei) {

        if (si > ei) {
            return null;
        }
        if (si == ei) {
            return new BinaryTreeNode<Integer>(arr[si]);
        }

        int rootIndex = (si + ei) / 2;
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(arr[rootIndex]);
        rootNode.left = insert(arr, si, rootIndex - 1);
        rootNode.right = insert(arr, rootIndex + 1, ei);

        return rootNode;
    }
}
