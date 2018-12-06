package com.qingtian.easy._283;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/20
 */
public class Solution {


    public void moveZeroes(int[] nums) {

        int position = 0;
        for (int x : nums)
            if (x != 0) nums[position++] = x;

        while (position < nums.length)
            nums[position++] = 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        for (int x : nums) System.out.printf(x + " ");
    }
}
