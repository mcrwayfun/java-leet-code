package com.qingtian.explore._242;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/24
 */
public class Solution1 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)-'a']++;
            letters[t.charAt(i)-'a']--;
        }

        for(int x:letters){
            if (x != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "cat";
        String t = "gat";

        boolean anagram = new Solution1().isAnagram(s, t);
        System.out.println(anagram);
    }
}
