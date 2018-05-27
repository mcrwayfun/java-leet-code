package com.qingtian.explore._028;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/25
 */
public class Solution {

    public int strStr(String haystack, String needle) {

        int hayLength = haystack.length();
        int ndlLength = needle.length();

        if (ndlLength == 0)
            return 0;
        if (hayLength < ndlLength)
            return -1;

        for (int i = 0; i <= hayLength - ndlLength; i++) {
            for (int j = 0; ; j++) {
                if (j == ndlLength)
                    return i;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;

            }
        }

        return -1;
    }


    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        int i = new Solution().strStr(haystack, needle);
        System.out.println(i);
    }


}
