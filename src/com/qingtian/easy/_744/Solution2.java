package com.qingtian.easy._744;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/06/21
 */
public class Solution2 {


    public char nextGreatestLetter(char[] letters, char target) {

        if (letters == null || letters.length == 0)
            throw new IllegalArgumentException();

        // target 大于 letters最后一个元素，直接返回头元素
        int length = letters.length - 1;
        if (target >= letters[length])
            return letters[0];

        int left = 0, right = length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] <= target)
                left = mid + 1;
            else right = mid;
        }

        return letters[right];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'g'};
        char target = 'a';
        char c = new Solution2().nextGreatestLetter(letters, target);
        System.out.println(c);
    }

}
