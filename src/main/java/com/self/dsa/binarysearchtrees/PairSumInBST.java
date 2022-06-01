package com.self.dsa.binarysearchtrees;

import java.util.Stack;

/**
 *
 * Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).
 */
public class PairSumInBST {

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {

        Stack<Integer> stack = new Stack<>();
        printPairs(root, s, stack);
    }

    private static void printPairs(BinaryTreeNode<Integer> node, int sum, Stack<Integer> stack) {

        if(node == null)
            return;

        printPairs(node.left, sum, stack);

        while(!stack.isEmpty() && stack.peek() < node.data) {
            stack.pop();
        }

        if(!stack.isEmpty() && stack.peek() == node.data) {
            stack.pop();
            System.out.println(sum - node.data +" "+node.data);
        }
        else {
            boolean isHalfNum = sum % 2 == 0 && node.data == sum/2;
            if (node.data < sum && !isHalfNum)
                stack.push(sum - node.data);
        }
        printPairs(node.right, sum, stack);
    }
}
