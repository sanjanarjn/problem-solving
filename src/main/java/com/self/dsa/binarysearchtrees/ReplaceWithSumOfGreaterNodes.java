package com.self.dsa.binarysearchtrees;

/**
 Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater or equal than it. You need to include the current node's data also.
 That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.

 */
public class ReplaceWithSumOfGreaterNodes {

    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {

        replace(root, 0);
    }

    private static int replace(BinaryTreeNode<Integer> node, int greaterSum) {

        if(node == null)
            return 0;

        int rightSum = replace(node.right, greaterSum);
        int nodeData = node.data;

        node.data = node.data + rightSum + greaterSum;

        int leftSum = replace(node.left, node.data);
        return rightSum + leftSum + nodeData;
    }
}
