package com.self.dsa.stacks;


import java.util.Stack;

/**
 For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.
 If the expression can't be balanced, return -1.
 Example:
 Expression: {{{{
 If we reverse the second and the fourth opening brackets, the whole expression will get balanced. Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

 Expression: {{{
 In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket and hence will not be able to make the expression balanced and the output will be -1.

 */
public class MinimumBracketReversal {

    public static int countBracketReversals(String input) {

        Stack<Character> stack = new Stack<>();

        int count = 0;
        int len = input.length();
        for(int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if(c == '{') {
                stack.push('{');
            }
            else {
                if(stack.isEmpty()) {
                    count++;
                    stack.push('{');
                }
                else {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()) {
            if(stack.size() % 2 == 0)
                count += stack.size()/2;
            else
                count = -1;
        }
        return count;
    }
}
