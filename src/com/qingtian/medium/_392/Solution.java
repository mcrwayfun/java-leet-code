package com.qingtian.medium._392;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/7/2
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {

        if (s == null || t == null || s.length() > t.length())
            return false;

        int i = 0, j = 0;
        int count = 0;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        while (j < charT.length && i < charS.length) {
            // 命中
            if (charS[i] == charT[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count == s.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean subsequence = new Solution().isSubsequence(s, t);
        System.out.println(subsequence);
    }
}
