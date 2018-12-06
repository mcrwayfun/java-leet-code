package com.qingtian.easy._136;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/17
 */
public class Solution {


    public int singleNumber(int[] nums) {

        int length = nums.length;

        if (length % 2 == 0)
            return 0;

        if (length == 1) {
            return nums[0];
        }

        int temp = 0;
        // 利用异或运算
        // 数与自己异或，返回0
        // 与0异或，返回自己
        for (int i = 0; i < length; i++) {
            temp = temp ^ nums[i];
        }

        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums = {4, 1, 2, 1, 2};
        int[] nums = {1, 2, 2};
        int singleNumber = solution.singleNumber(nums);
        System.out.println(singleNumber);
    }
}
