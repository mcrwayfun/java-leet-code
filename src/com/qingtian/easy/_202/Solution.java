package com.qingtian.easy._202;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/16
 * @description
 */
public class Solution {

    public boolean isHappy(int n) {
        if (n <= 0)
            return false;

        if (n == 1)
            return true;

        // 非快乐数循环会重复出现某个数
        Set<Integer> set = new HashSet<>();
        int remain = 0, sum = 0;
        while (set.add(n)) {
            sum = 0;
            while (n > 0) {
                remain = n % 10;
                sum += remain * remain;
                n = n / 10;
            }
            if (sum == 1)
                return true;
            else
                n = sum;
        }

        return false;
    }

    public static void main(String[] args) {
        boolean happy = new Solution().isHappy(19);
        System.out.println("19 is happy? " + happy);

        happy = new Solution().isHappy(11);
        System.out.println("11 is happy? " + happy);

    }
}
