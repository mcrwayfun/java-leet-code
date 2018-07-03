package com.qingtian.medium._153;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/7/3
 */
public class Solution {


    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        int left = 0, right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[0];
        }

        // 进行了旋转
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[left] < nums[mid])
                left = mid + 1;
            else right = mid;
        }

        return Math.min(nums[left], nums[right]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int min = new Solution().findMin(nums);
        System.out.println(min);
    }
}
