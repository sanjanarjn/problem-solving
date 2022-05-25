package com.self.dsa.linkedlist;


/**
 * Reverse a linkedlist in O(1) space and O(n) complexity
 *
 * @author sanjanarjn
 */
public class ReverseLinkedList {

    public static ListNode reverseLinkedList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedListHead = head;
        ListNode reversedListTail = head;

        ListNode current = head.next;

        while (current != null) {
            reversedListTail.next = current.next;
            current.next = reversedListHead;

            reversedListHead = current;
            current = reversedListTail.next;
        }
        return reversedListHead;
    }
}
