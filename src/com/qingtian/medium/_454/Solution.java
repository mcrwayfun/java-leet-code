package com.qingtian.medium._454;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/27
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if (A.length != B.length || B.length != C.length || C.length != D.length
                || A.length == 0)
            return 0;


        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        // 默认数组ABCD有共同的length
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m1.put(A[i] + B[j], m1.getOrDefault(A[i] + B[j], 0) + 1);
                m2.put(C[i] + D[j], m2.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }

        int res = 0;

        for (int x : m1.keySet()) {
            res += m2.containsKey(-x) ? m1.get(x) * m2.get(-x) : 0;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-1, -1};
        int[] B = new int[]{-1, 1};
        int[] C = new int[]{-1, 1};
        int[] D = new int[]{1, -1};
        int count = new Solution().fourSumCount(A, B, C, D);
        System.out.println(count);
    }
}
