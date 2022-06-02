package com.self.dsa.trees;
/*

Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.
 */
class MaxSumAnswer {
    int maxSum;
    TreeNode<Integer> maxNode;

    MaxSumAnswer() {

    }

    MaxSumAnswer(int maxSum, TreeNode<Integer> maxNode) {
        this.maxSum = maxSum;
        this.maxNode = maxNode;
    }
}

public class MaxSumNode {

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){

        return getMaxNode(root).maxNode;
    }

    private static MaxSumAnswer getMaxNode(TreeNode<Integer> node) {

        if(node == null) {
            return new MaxSumAnswer(0, null);
        }

        int nodeSum = node.data;
        for(TreeNode<Integer> child: node.children) {
            nodeSum += child.data;
        }

        MaxSumAnswer answer = new MaxSumAnswer();
        answer.maxSum = nodeSum;
        answer.maxNode = node;

        for(TreeNode<Integer> child: node.children) {
            MaxSumAnswer childAnswer = getMaxNode(child);
            if(childAnswer.maxSum > answer.maxSum) {
                answer.maxSum = childAnswer.maxSum;
                answer.maxNode = childAnswer.maxNode;
            }
        }
        return answer;

    }
}
