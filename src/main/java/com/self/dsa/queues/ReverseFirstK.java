package com.self.dsa.queues;

import java.util.Queue;

public class ReverseFirstK {

    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {

        input = reverseK(input, k);
        int count = 0;
        while(count < input.size() - k) {
            input.add(input.remove());
            count++;
        }
        return input;
    }

    public static Queue<Integer> reverseK(Queue<Integer> input, int k) {

        if(k == 0 || input.isEmpty())
            return input;

        int elem = input.remove();
        input = reverseK(input, k - 1);
        input.add(elem);

        return input;
    }
}
