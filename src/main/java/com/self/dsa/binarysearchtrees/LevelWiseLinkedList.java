package com.self.dsa.binarysearchtrees;

import com.self.dsa.linkedlist.LinkedListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelWiseLinkedList {

    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){


        if(root == null)
            return null;

        Queue<ArrayList<BinaryTreeNode>> queue = new LinkedList<>();
        ArrayList<BinaryTreeNode> rootLevel = new ArrayList<>();
        rootLevel.add(root);
        queue.add(rootLevel);

        ArrayList<LinkedListNode<Integer>> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            ArrayList<BinaryTreeNode> levelNodes = queue.remove();
            ArrayList<BinaryTreeNode> children = new ArrayList<>();

            LinkedListNode<Integer> levelHead = null;
            LinkedListNode<Integer> levelTail = null;

            for(BinaryTreeNode node: levelNodes) {
                LinkedListNode<Integer> newNode = new LinkedListNode(node.data);
                if(levelHead == null) {
                    levelHead = newNode;
                    levelTail = newNode;
                }
                else {
                    levelTail.next = newNode;
                    levelTail = newNode;
                }

                if(node.left != null)
                    children.add(node.left);

                if(node.right != null)
                    children.add(node.right);
            }
            if(!children.isEmpty())
                queue.add(children);
            if(levelHead != null)
                answer.add(levelHead);
        }
        return answer;
    }
}
