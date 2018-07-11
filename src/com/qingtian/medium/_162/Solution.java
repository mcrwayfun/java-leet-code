package com.qingtian.medium._162;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/7/11
 */
public class Solution {

    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,5,6,4};
        int peakElement = new Solution().findPeakElement(nums);
        System.out.println(peakElement);
    }
}
