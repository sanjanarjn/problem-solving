package com.self.dsa.linkedlist;

public class DeleteAlternateNodes {
    public static void deleteAlternateNodes(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> curr = head;
        while(curr != null && curr.next != null) {
            LinkedListNode<Integer> newCurr = curr.next.next;
            curr.next = newCurr;
            curr = newCurr;
        }
    }
}
