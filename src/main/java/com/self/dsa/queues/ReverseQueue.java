package com.self.dsa.queues;

import java.util.Queue;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> input) {

        if(input.isEmpty())
            return;

        int elem = input.remove();
        reverseQueue(input);
        input.add(elem);
    }
}
