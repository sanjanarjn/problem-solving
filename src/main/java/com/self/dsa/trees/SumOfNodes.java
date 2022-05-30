package com.self.dsa.trees;

public class SumOfNodes {

    public static int getSum(BinaryTreeNode<Integer> root) {

        if(root == null)
            return 0;

        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);

        return root.data + leftSum + rightSum;
    }

}
