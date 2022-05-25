package com.self.dsa.linkedlist;

public class SwapNodes {

    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {

        if(i == j)
            return head;

        if(i > j) {
            int iTemp = i;
            i = j;
            j = iTemp;
        }

        int count = 0;
        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> i_minus_1 = null, ith = null;
        LinkedListNode<Integer> j_minus_1 = null, jth = null;
        while(count < j && temp != null) {
            if(count == i - 1) {
                i_minus_1 = temp;
            }
            if(count == i) {
                ith = temp;
            }
            if(count == j - 1) {
                j_minus_1 = temp;
                jth = temp.next;
            }
            count++;
            temp = temp.next;
        }

        boolean isIHead = i == 0;
        boolean isIJAdjacent = i == j -1;
        if(isIJAdjacent) {
            if(i_minus_1 != null)
                i_minus_1.next = jth;
            j_minus_1.next = jth.next;
            jth.next = ith;
        }
        else {
            if(i_minus_1 != null)
                i_minus_1.next = jth;
            if(j_minus_1 != null)
                j_minus_1.next = ith;

            LinkedListNode<Integer> iNext = ith.next;
            ith.next = jth.next;
            jth.next = iNext;
        }
        if(isIHead)
            head = jth;

        return head;
    }
}