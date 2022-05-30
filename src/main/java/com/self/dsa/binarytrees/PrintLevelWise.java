package com.self.dsa.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelWise {

    public static void printLevelWise(BinaryTreeNode<Integer> root) {

        if(root == null)
            return;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            BinaryTreeNode<Integer> node = queue.remove();

            String left = node.left == null ? "-1" : node.left.data+"";
            String right = node.right == null ? "-1": node.right.data+"";
            System.out.println(node.data +":L:"+left+",R:"+right);

            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }

        }
    }
}
