package com.qingtian.easy._069;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/26
 */
public class Solution {


    public int mySqrt(int x) {

        if (x == 0)
            return 0;

        if (x == 1)
            return 1;

        int left = 1, right = x / 2;
        while (left <= right) {

            long mid = (left + right) >>> 1;
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid > x)
                right = (int) mid - 1;
            else {
                if ((mid + 1) * (mid + 1) > x)
                    return (int) mid;
                else
                    left = (int) mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int x = 3;
        int mySqrt = new Solution().mySqrt(x);
        System.out.println(mySqrt);
    }
}
