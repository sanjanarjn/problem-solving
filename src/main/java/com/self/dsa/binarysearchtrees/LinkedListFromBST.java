package com.self.dsa.binarysearchtrees;

import com.self.dsa.linkedlist.LinkedListNode;

public class LinkedListFromBST {

    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

        if(root == null)
            return null;

        LinkedListNode<Integer> left = constructLinkedList(root.left);
        LinkedListNode<Integer> rootNode = new LinkedListNode<>(root.data);
        LinkedListNode<Integer> right = constructLinkedList(root.right);

        LinkedListNode<Integer> temp = left;
        while(temp != null && temp.next != null) {
            temp = temp.next;
        }
        if(temp == null) {
            left = rootNode;
        }
        else {
            temp.next = rootNode;
        }
        rootNode.next = right;

        return left;
    }
}
