package com.qingtian.explore._065;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/20
 */
public class Solution {

    public int[] plusOne(int[] digits) {

        int count = digits.length;
        for (int i = count - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newInt = new int[count + 1];
        newInt[0] = 1;
        return newInt;
    }


    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        int[] plusOne = new Solution().plusOne(digits);
        for(int x:plusOne){
            System.out.printf(x + " ");
        }
    }
}
