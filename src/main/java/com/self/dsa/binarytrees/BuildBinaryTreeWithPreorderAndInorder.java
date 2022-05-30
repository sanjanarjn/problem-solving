package com.self.dsa.binarytrees;

public class BuildBinaryTreeWithPreorderAndInorder {

    public BinaryTreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public BinaryTreeNode buildTree(int[] preorder, int preSi, int preEi, int[] inorder, int inSi, int inEi) {

        if (preSi > preEi)
            return null;

        if (preSi == preEi) {
            return new BinaryTreeNode(preorder[preSi]);
        }

        int root = preorder[preSi];
        int inorderRootIndex = -1;
        for (int i = inSi; i <= inEi; i++) {
            if (root == inorder[i]) {
                inorderRootIndex = i;
                break;
            }
        }

        int leftTreeLength = inorderRootIndex - inSi;

        BinaryTreeNode rootNode = new BinaryTreeNode(root);
        BinaryTreeNode leftTree = buildTree(preorder, preSi + 1, preSi + leftTreeLength, inorder, inSi, inorderRootIndex - 1);
        BinaryTreeNode rightTree = buildTree(preorder, preSi + leftTreeLength + 1, preEi, inorder, inorderRootIndex + 1,
                inEi);

        rootNode.left = leftTree;
        rootNode.right = rightTree;

        return rootNode;
    }
}