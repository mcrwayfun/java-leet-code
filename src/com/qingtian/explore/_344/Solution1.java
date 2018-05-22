package com.qingtian.explore._344;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/22
 */
public class Solution1 {

    public String reverseString(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }

    public static void main(String[] args) {
        String s = "hello";
        String result = new Solution1().reverseString(s);
        System.out.println(result);
    }
}
