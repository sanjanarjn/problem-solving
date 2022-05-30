package com.self.dsa.linkedlist;

/**
 Given a large number represented in the form of a linked list.
 Write code to increment the number by 1 in-place(i.e. without using extra space).

 */
public class NextNumber {

    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {

        if(head == null) {
            return head;
        }

        LinkedListNode<Integer> temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        if(temp.data < 9) {
            temp.data = temp.data + 1;
            return head;
        }

        int carry = increment(head);
        if(carry == 1) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    private static int increment(LinkedListNode<Integer> head) {

        if(head == null)
            return 1;

        int carry = increment(head.next);
        int newValue = head.data + carry;
        if(newValue <= 9) {
            carry = 0;
            head.data = newValue;
        }
        else {
            carry = 1;
            head.data = 0;
        }
        return carry;
    }
}
