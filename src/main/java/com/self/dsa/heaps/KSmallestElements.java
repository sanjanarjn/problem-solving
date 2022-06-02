package com.self.dsa.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestElements {
    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < input.length; i++) {
            if(pq.size() == k && pq.peek() > input[i]) {
                pq.remove();
                pq.add(input[i]);
            }
            if(pq.size() < k)
                pq.add(input[i]);
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        while(!pq.isEmpty()) {
            output.add(pq.remove());
        }
        return output;

    }
}
