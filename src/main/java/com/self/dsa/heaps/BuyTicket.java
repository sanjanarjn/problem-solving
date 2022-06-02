package com.self.dsa.heaps;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyTicket {
    public static int buyTicket(int input[], int k) {

        if(input == null)
            return 0;

        Queue<Integer> indexQ = new LinkedList<>();
        for(int i = 0; i < input.length; i++) {
            indexQ.add(i);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < input.length; i++) {
            pq.add(input[i]);
        }
        int time = 0;
        while(!indexQ.isEmpty()) {

            int index = indexQ.remove();
            if(input[index] < pq.peek()) {
                indexQ.add(index);
            }
            else {
                pq.remove();
                time++;
                if(index == k) {
                    break;
                }

            }

        }
        return time;
    }
}
