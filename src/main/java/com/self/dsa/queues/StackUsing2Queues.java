package com.self.dsa.queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsing2Queues() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public int getSize() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public void push(int element) {
        q1.add(element);
    }

    public int pop() {

        while(q1.size() > 1) {
            q2.add(q1.remove());
        }
        int elem = -1;
        if(!q1.isEmpty())
            elem = q1.remove();

        while(!q2.isEmpty())
            q1.add(q2.remove());

        return elem;

    }

    public int top() {
        while(q1.size() > 1) {
            q2.add(q1.remove());
        }
        int elem = -1;
        if(!q1.isEmpty()) {
            elem = q1.remove();
            q2.add(elem);
        }
        while(!q2.isEmpty())
            q1.add(q2.remove());

        return elem;
    }
}
