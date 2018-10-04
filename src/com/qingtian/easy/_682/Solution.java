package com.qingtian.easy._682;

import java.util.Stack;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/8/6
 */
public class Solution {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();

        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }

    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        int sum = new Solution().calPoints(ops);
        System.out.println("结果sum为:" + sum);
    }
}
