package com.self.dsa.linkedlist;

class Answer {
    boolean isPal;
    LinkedListNode<Integer> p1;

    public Answer() {

    }

    public Answer(boolean isPal, LinkedListNode<Integer> p) {
        this.isPal = isPal;
        this.p1 = p1;
    }
}

public class PalindromeLinkedList {

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        return palindrome(head, head).isPal;
    }

    private static Answer palindrome(LinkedListNode<Integer> p1, LinkedListNode<Integer> p2) {

        if(p2 == null) {
            return new Answer(true, p1);
        }
        if(p2.next == null) {
            Answer answer = new Answer();
            if(p1.data.equals(p2.data)) {
                answer.isPal = true;
                answer.p1 = p1.next;
            }
            return answer;
        }

        Answer answer = palindrome(p1, p2.next);
        if(answer.isPal) {
            answer.isPal = answer.p1.data == p2.data;
            answer.p1 = answer.p1.next;
        }
        return answer;
    }
}