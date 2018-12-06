package com.qingtian.easy._014;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/27
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0)
            return "";

        int length = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            length = Math.min(length, strs[i].length());
            for (int j = 0; j < length; j++) {
               if(strs[0].charAt(j) != strs[i].charAt(j)){
                   length = j;
                   break;
               }
            }
        }
        return strs[0].substring(0,length);
    }

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        String prefix = new Solution().longestCommonPrefix(strs);
        System.out.println(prefix);
    }


}
