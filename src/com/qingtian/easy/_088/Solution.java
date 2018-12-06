package com.qingtian.easy._088;

import java.util.Arrays;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/8
 */
public class Solution {


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1.length < m + n || nums1.length == 0)
            return;

        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }

        Arrays.sort(nums1);
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new Solution().merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
