package com.qingtian.easy._744;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/06/21
 */
public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {

        if (letters == null || letters.length == 0)
            throw new IllegalArgumentException();

        int length = letters.length - 1;
        if (target > letters[length])
            return letters[0];

        int[] temp = new int[26];

        for (char letter : letters) {
            temp[letter - 'a'] = 1;
        }

        int start = target - 'a' + 1;
        for (int i = start; i < temp.length; i++) {

            if (temp[i] == 1)
                return (char) (i + 'a');
        }

        return letters[0];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'g'};
        char target = 'c';
        char c = new Solution().nextGreatestLetter(letters, target);
        System.out.println(c);
    }

}
