package com.self.dsa.linkedlist;

public class LinkedListOpsRecursive {

    public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {

        if (head == null) {
            return null;
        }
        if (pos == 0) {
            return head.next;
        }
        else {
            head.next = deleteNodeRec(head.next, pos - 1);
        }
        return head;
    }

    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        LinkedListNode<Integer> reversedHead = reverseLinkedListRec(head.next);
        LinkedListNode<Integer> tail = reversedHead;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return reversedHead;
    }

}