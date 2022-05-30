package com.self.dsa.trees;

/**

 For a given Binary of type integer, find and return the ‘Diameter’.

 The diameter of a tree can be defined as the maximum distance between two leaf nodes.
 Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.

 */
class Answer {

    int diameter;
    int height;

    public Answer() {

    }

    public Answer(int dia, int height) {
        this.diameter = dia;
        this.height = height;
    }
}

public class DiameterOfBinaryTree {

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        return 1 + findDiameter(root).diameter;
    }

    private static Answer findDiameter(BinaryTreeNode<Integer> node) {

        if(node == null) {
            return new Answer(0, 0);
        }

        Answer left = findDiameter(node.left);
        Answer right = findDiameter(node.right);

        int height = 1 + Math.max(left.height, right.height);
        int diameter = Math.max(left.height + right.height, Math.max(left.diameter, right.diameter));

        return new Answer(diameter, height);
    }
}