package com.self.dsa.linkedlist;

public class SkipMDeleteN {

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {

        if (M == 0) {
            return null;
        }

        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prev = null;
        while (curr != null) {
            int m = 0;
            int n = 0;

            while (m < M && curr != null) {
                m++;
                prev = curr;
                curr = curr.next;
            }
            while (n < N & curr != null) {
                n++;
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        return head;
    }
}