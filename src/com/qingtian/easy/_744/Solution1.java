package com.qingtian.easy._744;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/06/21
 */
public class Solution1 {

    public char nextGreatestLetter(char[] letters, char target) {

        if (letters == null || letters.length == 0)
            throw new IllegalArgumentException();

        // target 大于 letters最后一个元素，直接返回头元素
        int length = letters.length - 1;
        if (target >= letters[length])
            return letters[0];

        for (char ch : letters) {
            if(ch > target)
                return ch;
        }

        return letters[0];
    }


    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'g'};
        char target = 'c';
        char c = new Solution1().nextGreatestLetter(letters, target);
        System.out.println(c);
    }
}
