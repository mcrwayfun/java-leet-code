package com.qingtian.easy._371;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/14
 * @description
 */
public class Solution {

    public int getSum(int a, int b) {
        if (b == 0)
            return a;

        while (b != 0) {
            int sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }

        return a;
    }

}
