package org.example;

import java.util.Stack;

public class Leet20 {

    public boolean isValid(String s) {
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();
        for (String ch : arr) {
            if (ch.equals("(") || ch.equals("{") || ch.equals("[")) {
                stack.push(ch);
            }
            if (ch.equals(")")) {
                if (stack.isEmpty()) return false;
                if (!stack.pop().equals("(")) return false;
            }
            if (ch.equals("}")) {
                if (stack.isEmpty()) return false;
                if (!stack.pop().equals("{")) return false;
            }
            if (ch.equals("]")) {
                if (stack.isEmpty()) return false;
                if (!stack.pop().equals("[")) return false;
            }
        }
        return true;
    }

    //()[]{}
    public boolean solution(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : arr) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }

        }
        return true;
    }
}
