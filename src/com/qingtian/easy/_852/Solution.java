package com.qingtian.easy._852;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/19
 */
public class Solution {


    public int peakIndexInMountainArray(int[] A) {

        if (A == null || A.length == 0)
            return 0;

        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        // 5
        int[] A = new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1};
        int index = new Solution().peakIndexInMountainArray(A);
        System.out.println(index);
    }
}
