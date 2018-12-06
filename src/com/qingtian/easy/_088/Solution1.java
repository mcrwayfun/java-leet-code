package com.qingtian.easy._088;

import java.util.Arrays;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/8
 */
public class Solution1 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1.length < m + n || nums1.length == 0)
            return;

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];

    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 5, 6, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3};
        new Solution1().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
