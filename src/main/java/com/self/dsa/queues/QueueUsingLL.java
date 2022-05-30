package com.self.dsa.queues;

public class QueueUsingLL {
    private Node front;
    private Node rear;
    private int size;

    public QueueUsingLL() {

    }

    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public int dequeue() {

        int temp = -1;
        if (front != null) {
            temp = front.data;
            front = front.next;
            size--;
        }
        return temp;
    }

    public int front() {
        return front == null ? -1 : front.data;
    }
}
