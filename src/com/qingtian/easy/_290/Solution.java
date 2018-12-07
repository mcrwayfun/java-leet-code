package com.qingtian.easy._290;

import java.util.HashMap;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/7
 */
public class Solution {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;

        HashMap<Character, String> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            // 存在c但是c对应的value不相等
            if (map.containsKey(c) && !map.get(c).equals(words[i]))
                return false;
            else if (!map.containsKey(c) && map.containsValue(words[i]))
                return false;
            else {
                map.put(c, words[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().wordPattern("abba", "dog cat cat dog");
        HashMap<Object, Integer> map = new HashMap<>();
    }
}
