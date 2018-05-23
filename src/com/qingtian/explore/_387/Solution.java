package com.qingtian.explore._387;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/23
 */
public class Solution {

    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();
        // 放入map中，若已经存在，则value++，否则value=1
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 遍历找出第一个value=1的key的index
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        int index = new Solution().firstUniqChar(s);
        System.out.println(index);
    }
}
