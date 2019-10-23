package com.tunyl.datastructrue;

import java.util.Stack;

/**
 * @author create by Tunyl on 2019/10/11
 * @version 1.0
 */
public class ValidS {

    public boolean isValid(String s) {
        s = s.trim();
        if (s.equals("")) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!stack.empty()) {
                int k = stack.peek() - s.charAt(i);
                if (k == -1 || k == -2) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }

        }
        // if the stack is empty ,the string entered is valid
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidS validS = new ValidS();
        boolean isValid = validS.isValid("{[}]");

        System.out.println(isValid);
    }
}
