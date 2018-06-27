package com.qingtian.medium._454;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/27
 */
public class Solution1 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int res = 0;
        int r = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                r = i + j;
                maps.put(r, maps.getOrDefault(r, 0) + 1);
            }
        }

        for (int i : C) {
            for (int j : D) {
                res += maps.getOrDefault(-i - j, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-1, -1};
        int[] B = new int[]{-1, 1};
        int[] C = new int[]{-1, 1};
        int[] D = new int[]{1, -1};
        int count = new Solution1().fourSumCount(A, B, C, D);
        System.out.println(count);
    }
}
