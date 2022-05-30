package com.self.dsa.stacks;


import java.util.Stack;

/**

 For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
 A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.
 Example:
 Expression: (a+b)+c
 Since there are no needless brackets, hence, the output must be 'false'.

 Expression: ((a+b))
 The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.

 */

public class CheckRedundantBrackets {

    public static boolean checkRedundantBrackets(String expression) {

        boolean isRedundant = false;
        Stack<Character> stack = new Stack<>();

        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if(c == '(') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    isRedundant = true;
                    break;
                }
                stack.push(c);
            }
            if(isOperator(c)) {
                stack.push(c);
            }
            if(c == ')' && stack.peek() == '(') {
                isRedundant = true;
                break;
            }
        }
        return isRedundant;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*';
    }
}
