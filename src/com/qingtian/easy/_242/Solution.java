package com.qingtian.easy._242;

import java.util.Arrays;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/24
 */
public class Solution {


    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1,chars2);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean anagram = new Solution().isAnagram(s, t);
        System.out.println(anagram);
    }
}
