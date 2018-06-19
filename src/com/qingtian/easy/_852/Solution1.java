package com.qingtian.easy._852;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/19
 */
public class Solution1 {


    public int peakIndexInMountainArray(int[] A) {

        if (A == null || A.length == 0)
            return 0;

        int index = 0;

        while (A[index] < A[index + 1])
            index++;

        return index;
    }

    public static void main(String[] args) {
        // 5
        int[] A = new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1};
        int index = new Solution1().peakIndexInMountainArray(A);
        System.out.println(index);
    }
}
