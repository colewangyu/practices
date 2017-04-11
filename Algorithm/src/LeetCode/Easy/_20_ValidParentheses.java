package LeetCode.Easy;

import java.util.Stack;

/**
 * Created by cole on 2016-11-24.
 */
public class _20_ValidParentheses {
    public boolean isValid(String s) {
        char[] parentheses = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < parentheses.length; i++) {
            if (stack.isEmpty()) {
                stack.push(parentheses[i]);
                continue;
            } else {
                char a = stack.peek();
                char b = parentheses[i];
                if (a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}') {
                    stack.pop();
                } else {
                    stack.push(b);
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
