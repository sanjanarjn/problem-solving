package com.self.dsa.linkedlist;

public class LinkedListOps {

    public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data) {

        int count = 0;
        LinkedListNode<Integer> prev = head;

        LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
        } else {

            while (prev != null && count < pos - 1) {
                count++;
                prev = prev.next;
            }
            if (prev != null) {
                newNode.next = prev.next;
                prev.next = newNode;
            }
        }
        return head;
    }

    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {

        if (head == null)
            return null;

        if (pos == 0) {
            head = head.next;
        } else {
            int count = 0;
            LinkedListNode prev = head;
            while (count < pos - 1 && prev != null) {
                count++;
                prev = prev.next;
            }
            if (prev != null && prev.next != null) {
                prev.next = prev.next.next;
            }
        }
        return head;
    }

    public static int findNode(LinkedListNode<Integer> head, int n) {

        boolean found = false;
        int index = -1;
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            index++;

            if (temp.data == n) {
                found = true;
                break;
            }
            temp = temp.next;
        }
        return found ? index : -1;
    }

    public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {

        if (head == null || n == 0)
            return head;

        LinkedListNode<Integer> startPrev = null;
        LinkedListNode<Integer> start = head;
        LinkedListNode<Integer> end = head;

        int count = 0;
        while (count < n - 1) {
            count++;
            end = end.next;
        }
        while (end != null && end.next != null) {

            startPrev = start;
            start = start.next;
            end = end.next;
        }
        if (end != null && end != head) {
            startPrev.next = null;
            end.next = head;
            head = start;
        }
        return head;
    }

    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {

        if (head == null) {
            return null;
        }

        LinkedListNode<Integer> temp = head;
        while (temp.next != null) {
            if (temp.data.equals(temp.next.data)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void printReverse(LinkedListNode<Integer> root) {
        reverse(root);
    }

    private static void reverse(LinkedListNode<Integer> node) {

        if (node == null) {
            return;
        }
        reverse(node.next);
        System.out.print(node.data + " ");
    }
}
