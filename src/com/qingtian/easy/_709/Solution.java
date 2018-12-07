package com.qingtian.easy._709;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/7
 */
public class Solution {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();

        int sub = 'a' - 'A';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z')
                chars[i] = (char) (chars[i] + sub);
        }

        return String.valueOf(chars);
    }
}
