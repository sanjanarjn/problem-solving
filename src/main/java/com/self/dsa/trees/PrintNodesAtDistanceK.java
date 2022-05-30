package com.self.dsa.trees;

/**

 You are given a Binary Tree of type integer, a target node, and an integer value K.
 Print the data of all nodes that have a distance K from the target node.
 The order in which they would be printed will not matter.

 */
public class PrintNodesAtDistanceK {

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {

        if(root == null)
            return;
        printNodesAtK(root, node, k);
    }

    private static int printNodesAtK(BinaryTreeNode<Integer> node, int target, int k) {

        if(node == null) {
            return -1;
        }
        if(node.data == target) {
            printNodesInSubtreeAtK(node, k);
            return 0;
        }
        else {
            int dist = -1;
            int leftD = printNodesAtK(node.left, target, k);

            if(leftD != -1) {
                dist = leftD + 1;
                if(dist == k)
                    System.out.println(node.data);
                printNodesInSubtreeAtK(node.right, k - leftD - 2);
            }
            else {
                int rightD = printNodesAtK(node.right, target, k);
                if(rightD != -1) {
                    dist = rightD + 1;
                    if(dist == k)
                        System.out.println(node.data);
                    printNodesInSubtreeAtK(node.left, k - rightD - 2);
                }
            }
            return dist;
        }
    }

    private static void printNodesInSubtreeAtK(BinaryTreeNode<Integer> node, int k) {

        if(node == null)
            return;

        if(k < 0)
            return;

        if(k == 0)
            System.out.println(node.data);
        printNodesInSubtreeAtK(node.left, k-1);
        printNodesInSubtreeAtK(node.right, k-1);
    }
}
