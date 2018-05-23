package com.qingtian.explore._387;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/23
 */
public class Solution1 {

    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        int index = new Solution1().firstUniqChar(s);
        System.out.println(index);
    }

}
