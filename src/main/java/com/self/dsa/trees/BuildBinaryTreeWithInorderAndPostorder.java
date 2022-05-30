package com.self.dsa.trees;

public class BuildBinaryTreeWithInorderAndPostorder {

    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {

        int n = postOrder.length;
        return buildTree(postOrder, 0, n-1, inOrder, 0, n-1);
    }

    private static BinaryTreeNode<Integer> buildTree(int[] postOrder, int postSi, int postEi, int[] inOrder, int inSi, int inEi) {

        int rootData = postOrder[postEi];

        if(postSi == postEi) {
            return new BinaryTreeNode<>(postOrder[postEi]);
        }

        int rootIndex = findRootIndex(rootData, inOrder, inSi, inEi);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int leftCount = rootIndex - inSi;
        int rightCount = inEi - rootIndex;

        if(leftCount > 0) {
            BinaryTreeNode<Integer> leftTree = buildTree(postOrder, postSi, postSi + leftCount - 1, inOrder, inSi, rootIndex - 1);
            root.left = leftTree;
        }


        if(rightCount > 0) {
            BinaryTreeNode<Integer> rightTree = buildTree(postOrder, postSi + leftCount, postEi - 1, inOrder, rootIndex + 1, inEi);
            root.right = rightTree;
        }

        return root;
    }

    private static int findRootIndex(int data, int[] inOrder, int inSi, int inEi) {

        for(int i = inSi; i <= inEi; i++) {
            if(inOrder[i] == data)
                return i;
        }
        return -1;
    }
}