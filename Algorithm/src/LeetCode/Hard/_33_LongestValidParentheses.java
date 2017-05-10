package LeetCode.Hard;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class _33_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int result = 0;
        if (s == null || s.length() <= 1) {
            // do nothing
        } else {
            Stack<Integer> stack = new Stack<Integer>();
            int leftBound = -1;
            char[] chrs = s.toCharArray();
            for (int i = 0; i < chrs.length; i++) {
                if (chrs[i] == '(') { // push index of '('
                    stack.push(i);
                } else {
                    if (stack.isEmpty()) { // this ')' cannot pop, so change the left bound
                        leftBound = i;
                    } else {
                        stack.pop(); // pop index of '('
                        if (stack.isEmpty())
                            result = Math.max(result, i - leftBound);  // if empty, left bound is the variable 'leftbound'
                        else
                            result = Math.max(result, i - stack.peek());  // left bound is stack peek
                    }
                }
            }
            /*Stack<Integer> stack = new Stack<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                int t = stack.peek();
                if (t != -1 && s.charAt(i) == ')' && s.charAt(t) == '(') {
                    stack.pop();
                    result = Math.max(result, i - stack.peek());
                } else
                    stack.push(i);
            }*/
        }
        return result;
    }
}
