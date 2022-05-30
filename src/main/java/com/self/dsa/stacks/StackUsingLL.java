package com.self.dsa.stacks;

public class StackUsingLL {

    private Node top;
    private int size;

    public StackUsingLL() {
        //Implement the Constructor
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public int pop() {
        int elem = -1;
        if (top != null) {
            elem = top.data;
            top = top.next;
            size--;
        }
        return elem;
    }

    public int top() {
        return top == null ? -1 : top.data;
    }
}