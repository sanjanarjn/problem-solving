package com.self.dsa.stacks;

import java.util.Stack;

public class ReverseStack {

    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {

        while (!input.isEmpty()) {
            extra.push(input.pop());
        }
        reverse(extra, input);
    }

    public static void reverse(Stack<Integer> extra, Stack<Integer> input) {

        if (extra.isEmpty())
            return;

        int elem = extra.pop();
        reverse(extra, input);
        input.push(elem);
    }
}
