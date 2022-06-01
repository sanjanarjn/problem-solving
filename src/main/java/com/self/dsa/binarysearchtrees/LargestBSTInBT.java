package com.self.dsa.binarysearchtrees;

/*
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.
 */

class Answer {
    boolean isBST;
    int min;
    int max;
    int bstHeight;

    Answer() {

    }

    Answer(boolean isBST, int min, int max, int bstHeight) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.bstHeight = bstHeight;
    }
}
public class LargestBSTInBT {

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        return largestBST(root).bstHeight;
    }

    private static Answer largestBST(BinaryTreeNode<Integer> node) {

        if(node == null) {
            return new Answer(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Answer leftAns = largestBST(node.left);
        Answer rightAns = largestBST(node.right);

        Answer answer = new Answer();
        boolean isBST = leftAns.isBST && rightAns.isBST && node.data >= leftAns.max && node.data < rightAns.min;
        if(isBST) {
            answer.isBST = true;
            answer.bstHeight = Math.max(leftAns.bstHeight, rightAns.bstHeight) + 1;
            answer.min = Math.min(node.data, Math.min(leftAns.min, rightAns.min));
            answer.max = Math.max(node.data, Math.max(leftAns.max, rightAns.max));
        }
        else {
            answer.bstHeight = Math.max(leftAns.bstHeight, rightAns.bstHeight);
        }
        return answer;


    }
}
