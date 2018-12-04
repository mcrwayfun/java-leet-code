package com.qingtian.easy._070;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/4
 */
public class Solution {

    public int climbStairs(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();

        return climbStairsHelper(n);
    }

    private Map<Integer, Integer> map = new HashMap<>();

    private int climbStairsHelper(int n) {
        if (map.containsKey(n))
            return map.get(n);

        if (n <= 2)
            return n;

        int steps = climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
        map.put(n,steps);

        return steps;
    }

    public static void main(String[] args) {
        int steps = new Solution().climbStairs(44);
        System.out.println(steps);
    }
}
