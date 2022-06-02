package com.self.dsa.binarytrees;

/**

 For a given Binary of type integer, find and return the ‘Diameter’.

 The diameter of a tree can be defined as the maximum distance between two leaf nodes.
 Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.

 */
class DiameterAnswer {

    int diameter;
    int height;

    public DiameterAnswer() {

    }

    public DiameterAnswer(int dia, int height) {
        this.diameter = dia;
        this.height = height;
    }
}

public class DiameterOfBinaryTree {

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        return 1 + findDiameter(root).diameter;
    }

    private static DiameterAnswer findDiameter(BinaryTreeNode<Integer> node) {

        if(node == null) {
            return new DiameterAnswer(0, 0);
        }

        DiameterAnswer left = findDiameter(node.left);
        DiameterAnswer right = findDiameter(node.right);

        int height = 1 + Math.max(left.height, right.height);
        int diameter = Math.max(left.height + right.height, Math.max(left.diameter, right.diameter));

        return new DiameterAnswer(diameter, height);
    }
}