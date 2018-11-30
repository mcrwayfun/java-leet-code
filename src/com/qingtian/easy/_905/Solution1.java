package com.qingtian.easy._905;

import java.util.Arrays;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/30
 */
public class Solution1 {

    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0)
            throw new IllegalArgumentException();

        int[] ret = new int[A.length];
        // 记录数组中第一个奇数的位置
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0){
                int temp = A[i];
                A[i] = A[index];
                A[index++] = temp;
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int[] arrayByParity = new Solution().sortArrayByParity(nums);
        System.out.println(Arrays.toString(arrayByParity));
    }
}
