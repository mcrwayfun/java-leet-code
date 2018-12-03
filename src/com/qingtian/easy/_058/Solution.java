package com.qingtian.easy._058;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/3
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        String str = "        ";
        int length = new Solution().lengthOfLastWord(str);
        System.out.println(length);
    }
}
