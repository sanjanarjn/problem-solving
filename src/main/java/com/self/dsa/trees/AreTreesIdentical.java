package com.self.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

public class AreTreesIdentical {

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

        if(root1 == null && root2 == null)
            return true;

        if((root1 == null && root2 != null) || (root1 != null && root2 ==null))
            return false;

        Queue<TreeNode<Integer>> q1 = new LinkedList<>();
        Queue<TreeNode<Integer>> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while(!q1.isEmpty()) {
            TreeNode<Integer> node1 = q1.remove();
            TreeNode<Integer> node2 = q2.remove();

            if(node1.data != node2.data)
                return false;

            if(node1.children.size() != node2.children.size())
                return false;

            for(int i=0; i < node1.children.size(); i++) {
                q1.add(node1.children.get(i));
                q2.add(node2.children.get(i));
            }
        }
        return true;
    }
}
