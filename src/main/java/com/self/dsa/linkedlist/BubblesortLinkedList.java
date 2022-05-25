package com.self.dsa.linkedlist;

public class BubblesortLinkedList {

    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> iNode = head;
        LinkedListNode<Integer> iTailNode = null;

        while(iNode != iTailNode) {
            LinkedListNode<Integer> jPrevNode = null;
            LinkedListNode<Integer> jNode = iNode;

            while(jNode != null && jNode.next != null && jNode.next != iTailNode) {
                LinkedListNode<Integer> jNextNode = jNode.next;
                if(jNode.data > jNextNode.data) {
                    head = swap(head, jPrevNode, jNode, jNextNode);
                }
                jPrevNode = jNode;
                jNode = jNextNode;
            }
            iNode = head;
            iTailNode = jNode;
        }
        return head;
    }

    private static LinkedListNode<Integer> swap(LinkedListNode<Integer> head, LinkedListNode<Integer> jPrev, LinkedListNode<Integer> jNode, LinkedListNode<Integer> jNext) {

        if(jPrev != null)
            jPrev.next = jNext;

        jNode.next = jNext.next;
        jNext.next = jNode;

        if(jNode == head)
            head = jNext;

        return head;
    }
}