package com.qingtian.easy._367;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/25
 */
public class Solution {

    public boolean isPerfectSquare(int num) {
        if (num <= 0)
            return false;

        if (num == 1)
            return true;

        int left = 1, right = num / 2;
        while (left <= right) {

            long mid = (right + left) >>> 1;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num)
                left = (int) mid + 1;
            else
                right = (int) mid - 1;
        }

        return false;

    }

    public static void main(String[] args) {
        int num = 2147483647;
        boolean perfectSquare = new Solution().isPerfectSquare(num);
        System.out.println(perfectSquare);
    }
}
