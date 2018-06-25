package com.qingtian.easy._441;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/25
 */
public class Solution {

    public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}
