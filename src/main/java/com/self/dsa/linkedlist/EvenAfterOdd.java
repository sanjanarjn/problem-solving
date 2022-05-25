package com.self.dsa.linkedlist;

class LL<T> {
    LinkedListNode<T> head;
    LinkedListNode<T> tail;

    public LL(LinkedListNode<T> head, LinkedListNode<T> tail) {
        this.head = head;
        this.tail = tail;
    }
}

public class EvenAfterOdd {

    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {

        LL<Integer> oddLL = new LL<>(null, null);

        LL<Integer> evenLL = new LL<>(null, null);

        LinkedListNode<Integer> curr = head;
        while (curr != null) {

            LinkedListNode<Integer> nextCurr = curr.next;
            if (curr.data % 2 == 0) {
                appendToEither(evenLL, curr);
            }
            else {
                appendToEither(oddLL, curr);
            }
            curr.next = null;
            curr = nextCurr;
        }
        LinkedListNode<Integer> newHead = oddLL.head;
        if (oddLL.head == null) {
            newHead = evenLL.head;
        }
        else {
            oddLL.tail.next = evenLL.head;
        }
        return newHead;

    }

    private static LL<Integer> appendToEither(LL<Integer> ll, LinkedListNode<Integer> node) {

        if (ll.head == null) {
            ll.head = node;
            ll.tail = node;
        }
        else {
            ll.tail.next = node;
            ll.tail = node;
        }
        return ll;
    }
}