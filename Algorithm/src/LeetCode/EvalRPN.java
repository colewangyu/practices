package LeetCode;

/**
 * Created by wy on 2016-09-04.
 */
public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        String oper = "+-*/";
        Stack s1 = new Stack(tokens.length);
        for(int i = 0; i < tokens.length; i++) {
            if(oper.contains(tokens[i])) {
                s1.push(String.valueOf(calculate(s1.pop(), s1.pop(), tokens[i].toString())));
            } else {
                s1.push(tokens[i]);
            }
        }
        return new Integer(s1.pop());
    }

    private static int calculate(String s1, String s2, String oper) {
        if(oper.equals("+")) return new Integer(s2) + new Integer(s1);
        else if(oper.equals("-")) return new Integer(s2) - new Integer(s1);
        else if(oper.equals("*")) return new Integer(s2) * new Integer(s1);
        else return new Integer(s2) / new Integer(s1);
    }

    static class Stack {
        String[] strs;
        int top;
        int size;

        public Stack(int len){
            strs = new String[len];
            top = -1;
            size = len;
        }

        public void push(String s) {
            if(top < size - 1) {
                strs[++top] = s;
            }
        }

        public String pop() {
            if(top >= 0) {
                return strs[top--];
            }
            throw new NullPointerException();
        }

        public String peak() {
            if(top >= 0)
                return strs[top];
            return null;
        }
    }
}
