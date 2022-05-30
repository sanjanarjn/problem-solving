package com.self.dsa.trees;

public class CountNodesGreaterThanX {
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {

        if(root == null)
            return 0;

        int leftCount = countNodesGreaterThanX(root.left, x);
        int rightCount = countNodesGreaterThanX(root.right, x);

        int count = root.data > x ? 1 : 0;
        return count + leftCount + rightCount;
    }
}
