package com.qingtian.easy._844;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/8/7
 */
public class Solution {

    public boolean backspaceCompare(String S, String T) {


        if (S == null || T == null ||
                S.length() == 0 || T.length() == 0) {
            return false;
        }

        return buildString(S).equals(buildString(T));
    }

    private String buildString(String str) {

        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";

        // boolean result = new Solution().backspaceCompare(s, t);
        // System.out.println("比较的结果为:" + result);
        //
        // s = null;
        // result = new Solution().backspaceCompare(s, t);
        // System.out.println("s = null,比较的结果为:" + result);
        //
        // s = "";
        // result = new Solution().backspaceCompare(s, t);
        // System.out.println("s为空字符串,比较的结果为:" + result);
        //
        // s = "a##c";
        // t = "#a#c";
        // result = new Solution().backspaceCompare(s, t);
        // System.out.println("比较的结果为:" + result);

        s = "y#fo##f";
        t = "y#f#o##f";
        boolean result = new Solution().backspaceCompare(s, t);
        System.out.println("比较的结果为:" + result);
    }
}
