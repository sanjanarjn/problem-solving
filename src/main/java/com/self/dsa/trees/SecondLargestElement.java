package com.self.dsa.trees;


class SecondLargestAnswer {
    TreeNode<Integer> largest;
    TreeNode<Integer> secondLargest;

    SecondLargestAnswer() {

    }

    SecondLargestAnswer(TreeNode<Integer> largest, TreeNode<Integer> secondLargest) {
        this.largest = largest;
        this.secondLargest = secondLargest;
    }
}

public class SecondLargestElement {

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){

        return secondLargest(root).secondLargest;
    }

    private static SecondLargestAnswer secondLargest(TreeNode<Integer> node) {

        if(node == null)
            return new SecondLargestAnswer(null, null);

        SecondLargestAnswer answer = new SecondLargestAnswer(node, null);
        for(TreeNode<Integer> child: node.children) {
            SecondLargestAnswer childAns = secondLargest(child);
            if(answer.largest.data < childAns.largest.data) {
                if(childAns.secondLargest != null && answer.largest.data < childAns.secondLargest.data) {
                    answer = childAns;
                }
                else {
                    answer.secondLargest = answer.largest;
                    answer.largest = childAns.largest;
                }
            }
            else {
                if(answer.secondLargest != null) {
                    if(answer.secondLargest.data < childAns.largest.data && childAns.largest.data != answer.largest.data) {
                        answer.secondLargest = childAns.largest;
                    }
                }
                else {
                    if(childAns.largest.data != answer.largest.data)
                        answer.secondLargest = childAns.largest;
                    else
                        answer.secondLargest = childAns.secondLargest;
                }
            }
        }
        return answer;
    }
}
