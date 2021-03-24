package stack_queue;

import java.util.Stack;

public class ExpressionsConversion {

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String post = inToPost(exp);
        System.out.println(post);
        String in = postToIn(post);
        System.out.println(in);
        System.out.println(preToPost("*+AB-CD"));
    }

    private static String preToPost(String s) {
        Stack<String> st = new Stack<>();
        String out = "";
        for (int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (isOperator(c)) {
                String temp = "" + st.pop() + st.pop() + c;
                st.push(temp);
            } else {
                st.push(c+"");
            }
        }
        return st.peek();
    }

    private static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }

    private static String postToIn(String s) {
        Stack<String> st = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                st.push(c+"");
            } else {
                String exp = "(" + st.pop() + c + st.pop() + ")";
                st.push(exp);
            }
        }
        return st.peek();
    }

    private static String inToPost(String s) {

        Stack<Character> st = new Stack<>();

        String output = "";
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                output += c;
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    output += st.pop();
                }
                st.pop();
            } else {
                while(!st.isEmpty() && precedence(c) <= precedence(st.peek())) {
                    output += st.pop();
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()) {
            if (st.peek() == '(') {
                return "Invalid expression";
            }
            output += st.pop();
        }
        return output;
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
