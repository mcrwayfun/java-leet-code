package com.qingtian.easy._350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/20
 */
public class Solution {


    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null ||
                nums1.length == 0 || nums2.length == 0)
            return new int[]{};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[list.size()];
        int index = 0;
        for (int x : list) {
            result[index++] = x;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{1, 1};
        int[] intersection = new Solution().intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }
}
