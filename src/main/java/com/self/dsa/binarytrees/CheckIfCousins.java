package com.self.dsa.binarytrees;

/*

Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the two nodes are cousins of each other or not. Two nodes are said to be cousins of each other if they are at same level of the Binary Tree and have different parents.

 */

class CousinAnswer {
    int pDist = -1;
    int qDist = -1;
    boolean isSibling = false;

    CousinAnswer() {

    }

    CousinAnswer(int pDist, int qDist) {
        this.pDist = pDist;
        this.qDist = qDist;
    }
}

public class CheckIfCousins {

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {

        if(root == null)
            return false;

        CousinAnswer answer = checkIfCousin(root, p, q);
        if(answer.pDist == -1 && answer.qDist == -1)
            return true;

        return answer.pDist > 1 && answer.qDist > 1 && answer.pDist == answer.qDist && !answer.isSibling;
    }

    private static CousinAnswer checkIfCousin(BinaryTreeNode<Integer> node, int p, int q) {
        if(node == null) {
            return new CousinAnswer();
        }

        if(node.data == p) {
            CousinAnswer answer = new CousinAnswer();
            answer.pDist = 0;
            return answer;
        }
        if(node.data == q) {
            CousinAnswer answer = new CousinAnswer();
            answer.qDist = 0;
            return answer;
        }

        CousinAnswer leftAns = checkIfCousin(node.left, p, q);
        CousinAnswer rightAns = checkIfCousin(node.right, p, q);

        CousinAnswer answer = new CousinAnswer();
        int pDist = Math.max(leftAns.pDist, rightAns.pDist);
        answer.pDist = pDist != -1 ? pDist + 1 : -1;

        int qDist = Math.max(leftAns.qDist, rightAns.qDist);
        answer.qDist = qDist != -1 ? qDist + 1 : -1;
        answer.isSibling = leftAns.isSibling || rightAns.isSibling;
        if(answer.pDist == 1 && answer.qDist == 1) {
            answer.isSibling = true;
        }

        return answer;
    }
}
