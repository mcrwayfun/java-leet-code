package com.qingtian.easy._035;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/22
 */
public class Solution {


    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        int length = nums.length - 1;

        // add to end
        if (target > nums[length])
            return length + 1;

        // add to head
        if (target < nums[0])
            return 0;

        int left = 0, right = length;
        while (left <= right) {

            int mid = left + (right - left) >>> 1;
            int temp = nums[mid];

            if (temp == target)
                return mid;
            else if (temp < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 0;
        int searchInsert = new Solution().searchInsert(nums, target);
        System.out.println(searchInsert);
    }
}
