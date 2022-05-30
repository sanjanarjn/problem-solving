package com.self.dsa.queues;

public class DoubleEndedQueue {

    private int size;
    private int capacity;
    private Node front;
    private Node rear;

    public DoubleEndedQueue(int capacity) {

        this.capacity = capacity;
        this.size = 0;
    }

    public void insertFront(int elem) {

        if(size == capacity) {
            System.out.println(-1);
            return;
        }

        Node newNode = new Node(elem);
        if(front == null) {
            front = newNode;
            rear = newNode;
        }
        else {
            newNode.next = front;
            front = newNode;
        }
        size++;
    }

    public void insertRear(int elem) {

        if(size == capacity) {
            System.out.println(-1);
            return;
        }

        Node newNode = new Node(elem);
        if(front == null) {
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void deleteFront() {

        if(size == 0) {
            System.out.println(-1);
            return;
        }

        front = front.next;
        size--;

        if(size == 0) {
            front = null;
            rear = null;
        }
    }

    public void deleteRear() {

        if(size == 0) {
            System.out.println(-1);
            return;
        }
        Node temp = front;
        Node prev = null;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        rear = prev;

        size--;

        if(size == 0) {
            front = null;
            rear = null;
        }
    }

    public int getFront() {
        return size == 0 ? -1 : front.data;
    }

    public int getRear() {
        return size == 0 ? -1 : rear.data;
    }
}
