package com.self.dsa.binarysearchtrees;


public class IsBTreeBST {

    public static boolean isBST(BinaryTreeNode<Integer> root) {

        return checkIfBST(root).isBST;
    }

    private static IsBST checkIfBST(BinaryTreeNode<Integer> node) {

        if(node == null)
            return new IsBST(true, Integer.MAX_VALUE, Integer.MIN_VALUE);

        IsBST leftBst = checkIfBST(node.left);
        IsBST rightBst = checkIfBST(node.right);

        IsBST nodeBst = new IsBST();
        nodeBst.min = Math.min(node.data, Math.min(leftBst.min, rightBst.min));
        nodeBst.max = Math.max(node.data, Math.max(leftBst.max, rightBst.max));
        nodeBst.isBST = leftBst.isBST && rightBst.isBST ? node.data > leftBst.max && node.data <= rightBst.min : false;

        return nodeBst;

    }
}

class IsBST {
    boolean isBST;
    int min;
    int max;

    public IsBST() {

    }

    public IsBST(boolean isBST, int min, int max) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
    }
}
