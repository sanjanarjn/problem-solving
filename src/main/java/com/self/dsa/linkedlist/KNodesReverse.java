package com.self.dsa.linkedlist;

public class KNodesReverse {

    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {

        if(k <= 0)
            return head;

        int i = 0;

        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prevTail = null;
        while(curr != null) {

            int j = 0;
            LinkedListNode<Integer> prev = null;
            LinkedListNode<Integer> tail = curr;
            while(j < k && curr != null) {
                LinkedListNode<Integer> nextCurr = curr.next;
                curr.next = prev;

                prev = curr;
                curr = nextCurr;

                j++;
            }

            if(prevTail != null) {
                prevTail.next = prev;
            }
            prevTail = tail;

            if(i == 0) {
                head = prev;
            }
            i++;
        }
        return head;
    }
}