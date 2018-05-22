package com.qingtian.explore._344;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/22
 */
public class Solution {

    public String reverseString(String s) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }

        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        String s = "hello";
        String result = new Solution().reverseString(s);
        System.out.println(result);
    }
}
