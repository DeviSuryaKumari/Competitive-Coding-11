// Approach: Process the input string character by character, adding each to a queue. If the last enqueued character is greater than the
// current character, remove the last element from the queue while decrementing k until k becomes 0. If k is still positive after processing
// the entire string, remove characters from the end of the queue until k reaches 0. Remove any leading 0s from the queue before constructing
// and returning the final string. If the queue is empty, return "0".
// Time Complexity: O(n + k) where n - len(input str)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/remove-k-digits/description/

import java.util.Deque;
import java.util.ArrayDeque;

public class RemoveKDigits {

    String removeKDigits(String num, int k) {
        Deque<Character> Q = new ArrayDeque<>();
        for (char ch : num.toCharArray()) {
            while (k > 0 && !Q.isEmpty() && Q.peekLast() > ch) {
                Q.pollLast();
                k--;
            }
            Q.add(ch);
        }
        while (k > 0 && !Q.isEmpty()) {
            Q.pollLast();
            k--;
        }
        while (!Q.isEmpty() && Q.peekFirst() == '0') {
            Q.pollFirst();
        }
        StringBuilder ans = new StringBuilder();
        while (!Q.isEmpty()) {
            ans.append(Q.pollFirst());
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits rkd = new RemoveKDigits();
        // Input: num = "1432219", k = 3
        // Output: "1219"

        // Input: num = "10200", k = 1
        // Output: "200"

        // Input: num = "10", k = 2
        // Output: "0"

        // Input: num = "12345", k = 3
        // Output: "12"

        String num = "1432219";
        int k = 3;
        System.out.println("Given number after removing k digits: " + rkd.removeKDigits(num, k));
    }
}