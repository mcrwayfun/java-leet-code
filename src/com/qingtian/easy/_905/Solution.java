package com.qingtian.easy._905;

import java.util.Arrays;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/30
 */
public class Solution {

    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0)
            throw new IllegalArgumentException();

        int[] ret = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            if (temp % 2 == 0)
                ret[start++] = temp;
            else { // 奇数
                ret[end--] = temp;
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
