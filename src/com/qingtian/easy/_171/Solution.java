package com.qingtian.easy._171;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/15
 * @description
 */
public class Solution {

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            throw new IllegalArgumentException();

        int result = 0;
        for (int i = 0; i < s.length(); i++)
            result = result * 26 + (s.charAt(i) - 'A' + 1);

        return result;
    }

    public static void main(String[] args) {
        int number = new Solution().titleToNumber("ZY");
        System.out.println("result=" + number);
    }
}
