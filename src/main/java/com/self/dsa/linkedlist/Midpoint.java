package com.self.dsa.linkedlist;


public class Midpoint {

    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}