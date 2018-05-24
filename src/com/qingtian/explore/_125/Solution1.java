package com.qingtian.explore._125;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/24
 */
public class Solution1 {

    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = new Solution1().isPalindrome(s);
        System.out.println(palindrome);
    }
}
