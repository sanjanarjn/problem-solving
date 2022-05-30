package com.self.dsa.stacks;

import java.util.Stack;

public class BracketsBalanced {

    public static boolean isBalanced(String expression) {

        boolean isBalanced = true;
        Stack<Character> chars = new Stack<>();
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                chars.push(c);
            }
            if (c == ')') {
                isBalanced = !chars.isEmpty() && chars.pop() == '(';
                if (!isBalanced)
                    break;
            }
        }
        if (!chars.isEmpty())
            isBalanced = false;

        return isBalanced;
    }
}
