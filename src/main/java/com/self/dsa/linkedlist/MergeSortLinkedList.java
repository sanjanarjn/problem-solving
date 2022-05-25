package com.self.dsa.linkedlist;

public class MergeSortLinkedList {

    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {

        if(head == null || head.next == null)
            return head;

        LinkedListNode<Integer> mid = findMidpoint(head);
        LinkedListNode<Integer> midNext = mid.next;

        mid.next = null;

        LinkedListNode<Integer> head1 = mergeSort(head);
        LinkedListNode<Integer> head2 = mergeSort(midNext);

        return merge(head1, head2);
    }

    private static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

        LinkedListNode<Integer> p1 = head1;
        LinkedListNode<Integer> p2 = head2;

        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        while(p1 != null && p2 != null) {

            LinkedListNode<Integer> nextNode = null;
            if(p1.data <= p2.data) {
                nextNode = p1;
                p1 = p1.next;
            }
            else {
                nextNode = p2;
                p2 = p2.next;
            }
            if(head == null) {
                head = nextNode;
                tail = nextNode;
            }
            else {
                tail.next = nextNode;
                tail = nextNode;
            }
        }
        if(p1 != null) {
            tail.next = p1;
        }
        else {
            tail.next = p2;
        }
        return head;
    }

    private static LinkedListNode<Integer> findMidpoint(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}