package com.self.dsa.trees;

/*
Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.
 */
class NextMaxAnswer {
    int nextMax;
    TreeNode<Integer> node;

    NextMaxAnswer() {

    }

    NextMaxAnswer(int nextMax, TreeNode<Integer> node){
        this.nextMax = nextMax;
        this.node = node;
    }
}

public class NextLargerElement {

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){

        return getNextMax(root, n).node;
    }

    private static NextMaxAnswer getNextMax(TreeNode<Integer> root, int n) {

        if(root == null)
            return new NextMaxAnswer(0, null);


        NextMaxAnswer answer = new NextMaxAnswer(0, null);
        int childMax = Integer.MAX_VALUE;
        for(TreeNode<Integer> child: root.children) {
            NextMaxAnswer childans = getNextMax(child, n);
            if(childans.nextMax > n && childans.nextMax < childMax) {
                answer = childans;
                childMax = childans.nextMax;
            }
        }

        if(root.data > n && root.data < childMax) {
            answer.nextMax = root.data;
            answer.node = root;
        }
        return answer;
    }
}
