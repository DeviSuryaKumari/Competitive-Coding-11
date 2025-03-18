// Approach: This is postfix evaluation using a stack. Process the given tokens one by one. If a token is an operator, pop the stack twice to
// retrieve the operands, perform the corresponding binary operation, and push the result back onto the stack. If the current token is an
// operand, push it onto the stack. After processing the entire string, return the top of the stack as the final evaluation result.
// Time Complexity: O(n) where n - #tokens
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/evaluate-reverse-polish-notation/

import java.util.Deque;
import java.util.ArrayDeque;

public class EvaluateRPN {

    int evaluatePostfix(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s: tokens) {
            if (isOperator(s)) {
                int n2 = stack.pop();
                int n1 = stack.pop();
                if (s.equals("+")) {
                    stack.push(n1 + n2);
                } else if (s.equals("-")) {
                    stack.push(n1 - n2);
                } else if (s.equals("*")) {
                    stack.push(n1 * n2);
                } else {
                    stack.push(n1 / n2);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

    boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static void main(String[] args) {
        EvaluateRPN erpn = new EvaluateRPN();
        // Input: tokens = ["2","1","+","3","*"]
        // Output: 9

        // Input: tokens = ["4","13","5","/","+"]
        // Output: 6

        // Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        // Output: 22
        String[] tokens = { "10","6","9","3","+","-11","*","/","*","17","+","5","+" };
        System.out.println("Evaluation of given postfix expression: " + erpn.evaluatePostfix(tokens));
    }
}