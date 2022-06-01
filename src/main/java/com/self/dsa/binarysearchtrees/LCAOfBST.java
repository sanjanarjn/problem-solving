package com.self.dsa.binarysearchtrees;

public class LCAOfBST {

    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {

        if(root == null)
            return -1;

        int leftLca = getLCA(root.left, a, b);
        int rightLca = -1;
        if(leftLca == a || leftLca == b || leftLca == -1) {
            rightLca = getLCA(root.right, a, b);
        }

        if(root.data.equals(a) || root.data.equals(b))
            return root.data;

        boolean isLeftLCA = leftLca == a || leftLca == b;
        boolean isRightLCA = rightLca == a || rightLca == b;
        if(isLeftLCA && isRightLCA) {
            return root.data;
        }
        else if(isLeftLCA) {
            return leftLca;
        }
        else if(isRightLCA) {
            return rightLca;
        }
        else {
            return -1;
        }

    }
}
