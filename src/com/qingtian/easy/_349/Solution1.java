package com.qingtian.easy._349;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/20
 */
public class Solution1 {


    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null ||
                nums1.length == 0 || nums2.length == 0)
            return new int[]{};

        Arrays.sort(nums2);

        HashSet<Integer> intersectSet = new HashSet<>();


        int index = 0;
        while (index < nums1.length) {

            if (binarySearch(nums2, nums1[index]))
                intersectSet.add(nums1[index]);

            index++;
        }

        int[] result = new int[intersectSet.size()];

        index = 0;
        for (int x : intersectSet) {
            result[index++] = x;
        }

        return result;
    }

    private boolean binarySearch(int[] nums2, int target) {

        int left = 0, right = nums2.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums2[mid] < target)
                left = mid + 1;
            else if (nums2[mid] > target)
                right = mid - 1;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{1, 1};
        int[] intersection = new Solution1().intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }
}
