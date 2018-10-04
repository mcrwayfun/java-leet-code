package com.qingtian.easy._020;

import java.util.Stack;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/10/04
 * @description
 */
public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.empty())
                    return false;

                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
            }
        }

        return stack.empty();
    }

}
