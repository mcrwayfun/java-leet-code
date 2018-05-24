package com.qingtian.explore._125;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/24
 */
public class Solution {

    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end) {
            // 不是字母或者数字
            if (start < s.length() && !valid(chars[start]))
                start++;
            else if (end >= 0 && !valid(chars[end]))
                end--;
            else {
                if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end]))
                    return false;

                start++;
                end--;
            }

        }
        return true;
    }

    private Boolean valid(char c) {
        return ((c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9'));
    }


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = new Solution().isPalindrome(s);
        System.out.println(palindrome);
    }
}
